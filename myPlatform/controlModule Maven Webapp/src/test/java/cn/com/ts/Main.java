package cn.com.ts;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.com.ts.system.dao.SUserDao;
import cn.com.ts.system.model.SUser;

public class Main {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String myBatisConfig = "mybatis-config.xml";
		try {
			InputStream input = Resources.getResourceAsStream(myBatisConfig);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = ssfb.build(input);
			SqlSession session = factory.openSession();
			//SUser user = session.selectOne("cn.com.ts.system.dao.SUserDao.selectByPrimaryKey", "1");
			SUserDao userdao = session.getMapper(SUserDao.class);
			SUser user = userdao.selectByPrimaryKey("1");
			System.out.println(user.getChineseName());
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
