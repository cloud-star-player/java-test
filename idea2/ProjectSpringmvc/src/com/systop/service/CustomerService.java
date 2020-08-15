package com.systop.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.systop.pojo.Customer;

public interface CustomerService {
	public Customer findById(Integer cust_id);
	public Integer add(Customer c);
	public Integer insertemp(List<Customer>list);
	public int update(Customer c);
	public List<Customer> findpage(Integer Mpcounts,Integer Dpage);
	public Integer bncounts();
	public Integer delete(List list);
	public List<Customer> customerall();
	public Integer deletefyid(Integer cust_id);
	public List<Customer>customerx();
	public List<Customer>customerfindc(Customer cust);
}
