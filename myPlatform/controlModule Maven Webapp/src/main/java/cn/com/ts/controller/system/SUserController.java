package cn.com.ts.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.com.ts.system.model.SUser;
import cn.com.ts.system.service.SUserService;

@Controller
public class SUserController {
	
	@Autowired
	SUserService userService;

	public SUserController() {
		super();
		System.out.println("init SUserController................");
	}
	
	public void page(){
		SUser user = userService.selectByPrimaryKey("1");
		System.out.println(user.getChineseName());
	}

	
}
