package cn.com.ts;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.ts.system.dao.SUserDao;
import cn.com.ts.system.model.SUser;
import cn.com.ts.system.service.SUserService;
import cn.com.ts.system.service.impl.SUserServiceImpl;

public class myBatisStringTest {

	static SUserService userService;
	
	static SUserDao userDao;
	
	@BeforeClass
    public static void before(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        //userService = ctx.getBean(SUserServiceImpl.class);
        userDao = (SUserDao) ctx.getBean("SUserDao");
        userService = (SUserService) ctx.getBean("SUserServiceImpl");
        System.out.println(userService);
    }

	@Test
	public void test() {
		//ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
		//SUserDao userDao = (SUserDao)act.getBean("SUserDao");
		//System.out.println(userDao.selectByPrimaryKey("1"));
		SUser user = userService.selectByPrimaryKey("1");
		//SUser user = userDao.selectByPrimaryKey("1");
		System.out.println(user.getChineseName());
	}
	
	@Test
	public void insert(){
		SUser user = new SUser();
		user.setId("111");
		user.setChineseName("测试");
		userService.insert(user);
	}
	
	@Test
	public void update(){
		SUser user = new SUser();
		user.setId("111");
		user.setChineseName("测试111");
		userService.update(user);
	}
	
	@Test
	public void delete(){
		userService.delete("111");
	}
	

}
