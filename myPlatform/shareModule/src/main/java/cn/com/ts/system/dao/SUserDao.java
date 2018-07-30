package cn.com.ts.system.dao;

import cn.com.ts.base.BaseDao;
import cn.com.ts.system.model. SUser;
/**
 * 
 * @author jiangjiaxin
 * @date 
 */
public interface  SUserDao  extends BaseDao<String,  SUser>{
	
	public SUser selectByPrimaryKey(String id);
}
