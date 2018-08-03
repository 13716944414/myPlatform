package cn.com.ts.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import cn.com.ts.system.dao.SUserDao;
import cn.com.ts.system.model.SUser;
import cn.com.ts.system.service.SUserService;

/**
 * 
 * @author jiangjiaxin
 * @date 
 */
@Service
public class  SUserServiceImpl implements SUserService{
	
	@Autowired
	private SUserDao sUserDao;

	public  SUser selectByPrimaryKey(String id) {
		return sUserDao.selectByPrimaryKey(id);
	}

	public SUser selectByModel(SUser model) {
		return sUserDao.selectByModel(model);
	}

	public List<SUser> list(SUser model) {
		return sUserDao.list(model);
	}

	public List<SUser> page(SUser model) {
		return sUserDao.page(model);
	}

	public int count(SUser model) {
		return sUserDao.count(model);
	}

	public long max(String id) {
		return sUserDao.max(id);
	}

	public void insert(SUser model) {
		sUserDao.insert(model);
	}

	public void delete(String id) {
		sUserDao.delete(id);
	}

	public void update(SUser model) {
		sUserDao.update(model);
	}

	public void updateCondition(SUser model, SUser where) {
		sUserDao.updateCondition(model, where);
	}
}
