package com.systop.controller;

import java.util.List;
import java.util.UUID;
import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.systop.pojo.UserLogin;

import com.systop.service.UserLoginService;

@Controller

public class TestController {
//	@Autowired
//	private UserLoginService useLoginService;
	
	
	
    @RequestMapping("/test")
    public String sayHi(HttpServletRequest request,HttpServletRequest response,Model mav){
    	return "index";
    }
    @RequestMapping(value = "/user/{id}",method=RequestMethod.GET)
	public String selectUserById(String id) {
		return id;
	}
//    @RequestMapping("/selectUser")
//    public String selectuser(HttpServletRequest request) {
//    	String id=request.getParameter("id");
//    	System.out.println(id);
//		return "success";
//    }
//    @RequestMapping("/selectUser")	//跳转的注解
//	public String selectUser(Integer id) {
//		System.out.println(id);
//		return "success";
//	} 	
    @RequestMapping("/selectUser")	//跳转的注解
	public String selectUser(@RequestParam(value="user_id")Integer id) {
		System.out.println(id);
		return "success";
	}
    
    @RequestMapping("/toindex")	//跳转的注解
	public String selectUser() {
		
		return "index";
	}
    //也面条跳转
    //在类中有另一个类的情况下（联表查询可获取）
    @RequestMapping(value = "/index", method = RequestMethod.GET)
	public String toindex() {
		return "index";
	}
   //注意TestController的数据与"index"同步,其次jsp数据
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String login(UserLogin user, Model model, HttpSession session) {
		// 业务逻辑
		String username = user.getUser_code();
		String password = user.getUser_password();
		System.out.println(username);
		System.out.println(password);
		if (username != null && "admin".equals(username) && password != null && "admin".equals(password)) {
			session.setAttribute("user_session", user);
			return "redirect:main";
		}
		model.addAttribute("msg", "用户名或者密码错误，请重新登录！");
		return "index";
	}
	
	@RequestMapping("/main")
	public String toMain() {
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
    
    
    //对象集合数据获取
    @RequestMapping("/tologin2")
	public String toUser() {
		return "login2";
	}
	
	
	
	
	
	/**
	 * ajax测试                 注意ajax在input的name以及传参的数据最好是与pojo一样
	 * @return
	 */
	@RequestMapping("/ajax")
	public String ajax() {
		return "ajax";
	}
	@RequestMapping(value="/testJson",method=RequestMethod.POST)
	public @ResponseBody UserLogin testJson(@RequestBody UserLogin user) {
		System.out.println(user.getUser_code());
		System.out.println(user.getUser_password());
		user.setUser_password("123456");
		return user;
	}
	
	
	
	
	
	@RequestMapping("/restful")
	public String restful() {
		return "restful";
	}
	/**
	 * user不可以丢
	 * @param user_code
	 * @param user_password
	 * @return
	 */
	@RequestMapping(value="/user/{user_code}/{user_password}",method=RequestMethod.GET)
	@ResponseBody
	public UserLogin selectUser(@PathVariable("user_code") String user_code,@PathVariable("user_password") String user_password) {
		System.out.println(user_code);
		System.out.println(user_password);
		UserLogin user = new UserLogin();
		user.setUser_code(user_code);
		user.setUser_password(user_password);
		return user;
	}

}

