package cn.com.ts.base.page;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.commons.lang3.reflect.FieldUtils;

@Intercepts(value = { @Signature(args = { Connection.class,Integer.class }, method = "prepare", type = StatementHandler.class) })
public class PagePlugins implements Interceptor {

	public Object intercept(Invocation invocation) throws Throwable {
		try {
            // 获取目标对象，注意StatementHandler中的属性都是protected
            // 不能直接访问，因此需要通过其他的方式来获取，就是MetaObject
            // 其基本实现是BaseStatementHandler其中最重要的属性是MappedStatment
            // 包含了SQL相关信息
            StatementHandler handler  = (StatementHandler) invocation.getTarget();
            // 获取指定对象的元信息
            MetaObject metaObject = MetaObject.forObject(handler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
            // 然后就可以通过MetaObject获取对象的属性
            // 获取RoutingStatementHandler->PrepareStatementHandler->BaseStatementHandler中的mappedStatement
            // mappedStatement 包含了Sql的信息
            MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
            // 获取statement id
            String statementId = mappedStatement.getId();
            //if(statementId.endsWith("page")){
            if(statementId.contains("page")){
                BoundSql bound = handler.getBoundSql();
                //原SQL
                String sql = bound.getSql();
                System.out.println(sql);

                //拼接查询总记录数SQL
                String countSql = "select count(*) " + sql.substring(sql.indexOf("FROM"));
                System.out.println(countSql);
                Connection conn = (Connection)invocation.getArgs()[0];
                //预编译SQL
                PreparedStatement preparedStatement = conn.prepareStatement(countSql);

                //设置参数
                ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
                parameterHandler.setParameters(preparedStatement);

                //执行SQL
                ResultSet resultSet = preparedStatement.executeQuery();
                //总记录数
                int count = 0;
                if(resultSet.next()){
                    count = resultSet.getInt(1);
                }

                Object paramentObject = bound.getParameterObject();
                Page page = null;
                if(paramentObject instanceof Page){
                    page = (Page)paramentObject;
                }else{
                    page = (Page)this.getPageBean(paramentObject);
                }
                //设置总记录数
                page.setTotalRecord(count);
                //拼接分页SQL
                sql += " limit " + page.getCurrentRecord() + ", " + page.getPageSize();
                System.out.println(sql);
                //将拼接好的分页SQL设置到boundSql
                metaObject.setValue("delegate.boundSql.sql", sql);

                preparedStatement.close();
                resultSet.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
		return invocation.proceed();
	}
	
	private Object getPageBean(Object obj){
        Field[] fields = FieldUtils.getAllFields(obj.getClass());
        Object value = null;
        try {
            for(Field field : fields){
                if("page".equals(field.getName())){
                    if(field.isAccessible()){
                        value = field.get(obj);
                    }else{
                        field.setAccessible(true);
                        value = field.get(obj);
                        field.setAccessible(false);
                    }
                    break;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return value;
    }

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}

}
