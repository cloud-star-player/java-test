package com.systop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.systop.pojo.Customer;

public interface CustomerMapper {
	public Customer findById(@Param("cust_id")Integer cust_id);
	public Integer bncounts();
	public List<Customer> findpage(@Param("Mpcounts")Integer Mpcounts,@Param("Dpage")Integer Dpage);
	public Integer add(Customer c);
	public Integer insertemp(List<Customer>list);
	public int update(Customer c);
	public Integer delete(List list);
	public List<Customer> customerall();
	public Integer deletefyid(Integer cust_id);
	public List<Customer>customerx();
	public List<Customer>customerfindc(Customer cust);
}
