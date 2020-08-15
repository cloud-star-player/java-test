package com.systop.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.systop.pojo.Basedict;
import com.systop.pojo.Customer;
import com.systop.pojo.Interview;
import com.systop.pojo.UserLogin;
import com.systop.service.BasedictService;
import com.systop.service.CustomerService;
import com.systop.service.InterviewService;
import com.systop.service.UserLoginService;

@Controller
public class IntController {
	@Autowired
	public InterviewService interviewservice;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserLoginService userloginService;
	@Autowired
	private BasedictService basedictService;
	@RequestMapping("/interviewall")
	public String tointerview(@RequestParam(value="pn", defaultValue="1")Integer pn, Model model) {
		    PageHelper.startPage(pn,5);
	        List<Interview> dep=interviewservice.interselects();
	        System.out.println(dep+"jilu");
	        //ɧ������ ���������pageinfo�У����pageinfo���кܶ����õĲ���
	        PageInfo<Interview> list=new PageInfo<>(dep,5);
	   		//new PageInfo<>(dep)��ҳ  ����5��ҳnew PageInfo<>(dep,5);**
	        System.out.println("��ǰҳ��"+list.getPageNum());
	        System.out.println("��ҳ��"+list.getPages());
	        System.out.println("�ܼ�¼��"+list.getTotal());
	        System.out.println("��ǰҳ�м�����¼"+list.getSize());
	        System.out.println("��ǰҳ��pagesize"+list.getPageSize());
	        System.out.println("ǰһҳ"+list.getPrePage());
	        System.out.println("���"+list.getList());
	        int[] nums=list.getNavigatepageNums();
	        model.addAttribute("list", list);
	        List<UserLogin> list2=userloginService.userx();
	        List<Customer> list3=customerService.customerx();
	        List<Basedict> list4=basedictService.basedictsfrom();
	        List<Basedict> list5=basedictService.basedictsindust();
	        List<Basedict> list6=basedictService.basedictslevel();
	        model.addAttribute("user", list2);
	        model.addAttribute("customer", list3);
	        model.addAttribute("fromType", list4);
	        model.addAttribute("industryType", list5);
	        model.addAttribute("levelType", list6);
		    return "interview";
	}
	@RequestMapping("/interviewadd")
	public @ResponseBody Integer interviewadd(Integer cust_name,Integer user_name,String inter_record){
		Interview interview =new Interview();
		Customer cust = new Customer();
		UserLogin userlogin = new UserLogin();
		cust.setCust_id(cust_name);
		userlogin.setUser_id(user_name);
		interview.setInter_record(inter_record);
		interview.setCustomer(cust);
		interview.setUserlogin(userlogin);
        Integer i = interviewservice.interviewadd(interview);
		return i;
	}
	@RequestMapping("/interviewbyid")
	public @ResponseBody Interview interviewbyid(Integer inter_id) {
		
		Interview interview =interviewservice.interviewbyid(inter_id);
		return interview;
	}
	
	@RequestMapping("/customerbyids")
	public @ResponseBody Customer findCustomerById(Integer cust_id){
		Customer cust =customerService.findById(cust_id);
		return cust;
	}
	@RequestMapping("/deletefyids")
	public @ResponseBody Integer delete(Integer id){
        Integer i = customerService.deletefyid(id);
		return i;
	} 
}
