package com.systop.test;


import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.systop.dao.BasedictMapper;
import com.systop.dao.CustomerMapper;
import com.systop.dao.InterviewMapper;
import com.systop.dao.UserLoginMapper;
import com.systop.pojo.Basedict;
import com.systop.pojo.Customer;
import com.systop.pojo.Interview;
import com.systop.pojo.UserLogin;

public class test {
	public static void main(String[] args) {
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		/**
		 * 获取时间给需要时间的表插入添加使用
		 */
		Date date=new Date();  
        Timestamp timeStamp = new Timestamp(date.getTime());
        
        /**
         * sys_user表操作
         */
        /**
         * 注册
         */
//        UserLoginMapper userLoginMapper = (UserLoginMapper) app.getBean(UserLoginMapper.class);
//        UserLogin userlogin=new UserLogin();
//        userlogin.setUser_code("132");
//        userlogin.setUser_name("223");
//        userlogin.setUser_password("123");
//        userlogin.setUser_state("1");
//       
//        int i=userLoginMapper.register(userlogin);
//        if(i>0) {
//        	System.out.println("插入成功");
//        }
//        
		/**
		 * 登录
		 */
//		UserLoginMapper userLoginMapper = (UserLoginMapper) app.getBean(UserLoginMapper.class);
//		UserLogin u = userLoginMapper.login("m0004", "123");
//		System.out.println(u);
		
        /**
         * customer表操作
         */
		/**
		 * 按照id查询
		 */
//		CustomerMapper cust=app.getBean(CustomerMapper.class);
//		Customer c=cust.findById(29);
//		System.out.println(c);
		
		
		/**
		 * 修改数据
		 */
//		CustomerMapper cust=app.getBean(CustomerMapper.class);
//		Customer c=new Customer();
//		c.setCust_id(14);
//		c.setCust_name("sd");
//		c.setCust_address("123123");
//		c.setCust_createtime(timeStamp);
//		int c2=cust.update(c);
//		System.out.println("改了"+c2+"条数据");
		
		/**
		 * 添加数据
		 */
//      CustomerMapper cust=app.getBean(CustomerMapper.class);
//		Customer c=new Customer();
//		c.setCust_name("sd");
//		c.setCust_address("123123");
//		c.setCust_createtime(timeStamp);
//		int c2=cust.add(c);
//		System.out.println("插入"+c2+"条数据");
        /**
         * 批量插入
         */  
//      CustomerMapper cust=app.getBean(CustomerMapper.class);
//		Customer c=new Customer();
//		Customer c1=new Customer();
//		Customer c2=new Customer();
//		List<Customer>list=new ArrayList<Customer>();
//		c.setCust_name("c");
//		c.setCust_address("123123");
//		c.setCust_createtime(timeStamp);
//		c1.setCust_name("c1");
//		c1.setCust_address("1w23123");
//		c1.setCust_createtime(timeStamp);
//		c2.setCust_name("c2");
//		c2.setCust_address("123123");
//		c2.setCust_createtime(timeStamp);
//		list.add(c);
//		list.add(c1);
//		list.add(c2);
//		int a=cust.insertemp(list);
//		System.out.println("插入"+a+"条数据");
 
       
// BasedictMapper b=app.getBean(BasedictMapper.class);       
// List<Basedict>a=b.basedictsfrom();
// for(Basedict c:a) {
//	 System.out.println(c);
// }
		/**
		 * 分页查询
		 */	
//		CustomerMapper cust=app.getBean(CustomerMapper.class);
//		int page=2;                  //选择页数
//		int Dpage=10;               //设置  每页的数据
//		int Mpcounts=Dpage*(page-1);    //从Dpage+1条开始，取Dpage条。            
//		int Zpage;                     //总页数
//		List<Customer> c=cust.findpage(Mpcounts,Dpage);
//		for(Customer c2:c) {
//			System.out.println(c2+"123");
//		}
//		int counts=cust.bncounts();   //总条数
//		if(counts%Dpage==0) {
//			Zpage=counts/Dpage;
//		}else{
//			Zpage=counts/Dpage+1;
//		}
//		System.out.println("总条数"+counts);           //输出总条数
//		System.out.println("总页数"+Zpage);              //输出总页数
//        
        /**
         * 批量删除
         */
//        CustomerMapper cust=app.getBean(CustomerMapper.class);
//        List list=new ArrayList();
//        list.add(14);
//        list.add(15);
//        int a=cust.delete(list);
//        System.out.println("删除了"+a+"条");
        /**
         * Interview操作
         */
		/**
		 * 联合查询
		 */
//		InterviewMapper inw=app.getBean(InterviewMapper.class);
//		Interview inv=inw.uionselect(29);
//	    System.out.println(inv);
        InterviewMapper inw=app.getBean(InterviewMapper.class);
        List<Interview> ine=inw.interselects();
        for(Interview c2:ine) {
			System.out.println(c2+"123");
		}
	}
}
