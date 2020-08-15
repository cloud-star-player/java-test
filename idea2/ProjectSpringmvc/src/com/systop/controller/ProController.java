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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.systop.pojo.UserLogin;

import com.systop.service.UserLoginService;

@Controller

public class ProController {
	@Autowired
	private UserLoginService useLoginService;
	
	
    @RequestMapping("/tologin")
    public String tologin(){
    	return "login";
    }
    @RequestMapping("/login")
	public String tocustomer() {
		return "customer";
	}
    @PostMapping(value = "/user/{usercode}/{password}")
    public @ResponseBody
    Integer selectUser(@PathVariable("usercode") String usercode, @PathVariable("password") String password, HttpSession session) throws Exception {
        UserLogin a =useLoginService.login(usercode,password);
        session.setAttribute("user",a);
        int b = 1;
        if (a != null) {
            b = 1;
        } else {
            b = 0;
        }
        return b;
    }
}

