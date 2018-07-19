package com.dss.javaMail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dss.javaMail.entity.User;
import com.dss.javaMail.service.UserService;
import com.dss.javaMail.utils.MailUtil;
import com.dss.javaMail.utils.UuidUtil;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MailUtil mailUtil;
	
	@RequestMapping(value = "/goReg")
	public String getUser() {
		
		return "thymeleaf/register";
		
	}
	
	@RequestMapping(value = "/register")
	@ResponseBody
	public String register(User user) {
		
		user.setState(0);		//	0表示未激活/1表示激活
		user.setCode(UuidUtil.get32UUID());
		
		String result = mailUtil.send(user.getEmail(), user.getCode());
		
		System.out.println("发送邮件结果： " + result);
		
		System.out.println(user);
		
		userService.registerUser(user);
		
		return "success";
	}
	
	@RequestMapping(value = "/regActive")
	public String regActive(@RequestParam("code") String code,ModelMap map) {
		
		User user = new User();
		user.setCode(code);
		
		user = userService.getUserByCode(user);
		
		if(user != null) {
			
			if(user.getState() == 1) {
				
				map.addAttribute("message", "你已经激活过了...");
				
			}else {
				userService.updateState(user);
				map.addAttribute("message", "激活成功...");
			}
			
		}else {
			
			map.addAttribute("message", "激活失败...");
		}
		
		
		return "thymeleaf/result";
	}
	
}
