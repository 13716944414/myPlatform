package cn.com.ts;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.ts.system.dao.SUserDao;
import cn.com.ts.system.model.SUser;
import cn.com.ts.system.service.SUserService;
import cn.com.ts.system.service.impl.SUserServiceImpl;

public class myBatisStringTest {

	static SUserService userService;
	
	@BeforeClass
    public static void before(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
        userService = ctx.getBean(SUserServiceImpl.class);
    }

	@Test
	public void test() {
		//ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
		//SUserDao userDao = (SUserDao)act.getBean("SUserDao");
		//System.out.println(userDao.selectByPrimaryKey("1"));
		SUser user = userService.selectByPrimaryKey("1");
		System.out.println(user.getChineseName());
		
	}

}
