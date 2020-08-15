package com.systop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.systop.pojo.Basedict;
import com.systop.pojo.Customer;
import com.systop.service.BasedictService;
import com.systop.service.CustomerService;


@Controller
public class ConController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BasedictService basedictService;
	 @RequestMapping("/customerall")
	    public String list(@RequestParam(value="pn", defaultValue="1")Integer pn, Model model){
	        //������ѯ����ķ�ҳ������ڼ�ҳ�� ÿҳ���ټ�¼��
	        PageHelper.startPage(pn,5);
	        List<Customer> dep= customerService.customerall();
	        System.out.println(dep+"jilu");
	        //ɧ������ ���������pageinfo�У����pageinfo���кܶ����õĲ���
	        PageInfo<Customer> list=new PageInfo<>(dep,5);
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
	        List<Basedict> list2=basedictService.basedictsfrom();
	        List<Basedict> list3=basedictService.basedictsindust();
	        List<Basedict> list4=basedictService.basedictslevel();
	        model.addAttribute("fromType", list2);
	        model.addAttribute("industryType", list3);
	        model.addAttribute("levelType", list4);
	        return "customer";   //��ת��success.jsp ҳ��
	    }
	 @RequestMapping(value ="/customer/getCustomerById/{id}", method = RequestMethod.GET)
	 public @ResponseBody Customer userselect(@PathVariable("id")Integer id){
	     Customer cust=customerService.findById(id);
	     
	     return cust;
	 }
	 @RequestMapping(value ="/custupdate")
	 public @ResponseBody Integer userupdate(Customer cust){
	     Integer row=customerService.update(cust);
	     return row;
	 }
	 @RequestMapping(value ="/customadd")
	 public @ResponseBody Integer customadd(Customer cust){
	     Integer row=customerService.add(cust);
	     return row;
	 }
	 
	 @RequestMapping(value ="/customer/deletes/{id}", method = RequestMethod.POST)
	 public @ResponseBody Integer userdeletefyid(@PathVariable("id")Integer id)throws Exception {
	     Integer row=customerService.deletefyid(id);
	     return row;
	 }
	 @RequestMapping(value ="/customerfindc")
		public String customerfindc(@RequestParam(value="pn", defaultValue="1")Integer pn,Model model,String custName,String custSource,String custLevel,String custIndustry){
			Customer c=new Customer();
			c.setCust_name(custName);
			c.setCust_source(custSource);
			c.setCust_level(custLevel);
			c.setCust_industry(custIndustry);
			List<Customer> dep =customerService.customerfindc(c);
		    System.out.println(dep+"jilu");
		    //ɧ������ ���������pageinfo�У����pageinfo���кܶ����õĲ���
		    PageInfo<Customer> list=new PageInfo<>(dep,5);
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
		    List<Basedict> list2=basedictService.basedictsfrom();
	        List<Basedict> list3=basedictService.basedictsindust();
	        List<Basedict> list4=basedictService.basedictslevel();
	        model.addAttribute("fromType", list2);
	        model.addAttribute("industryType", list3);
	        model.addAttribute("levelType", list4);
			return "customer";
	}
}
