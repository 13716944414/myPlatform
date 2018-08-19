package cn.com.ts.controller.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.ts.system.model.SUser;
import cn.com.ts.system.service.SUserService;

@Controller
@RequestMapping(value="user")
public class SUserController {
	
	@Autowired
	SUserService userService;

	public SUserController() {
		super();
		System.out.println("init SUserController................");
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(HttpServletRequest request){
		return "system/user/index";
	}
	
	@ResponseBody
	@RequestMapping(value="page", method=RequestMethod.POST)
	public List<SUser> page(SUser model){
		List<SUser> list = userService.page(model);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getModelById/{id}", method=RequestMethod.POST)
	public SUser getModelById(@PathVariable("id") String id){
		SUser user = userService.selectByPrimaryKey(id);
		return user;
	}

	
}
