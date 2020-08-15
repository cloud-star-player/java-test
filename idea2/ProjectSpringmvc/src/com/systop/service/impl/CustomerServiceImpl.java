package com.systop.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systop.dao.CustomerMapper;
import com.systop.pojo.Customer;
import com.systop.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerMapper customerDao;

	@Override
	public Customer findById(Integer cust_id) {
		// TODO 自动生成的方法存根
		Customer cust=customerDao.findById(cust_id);
		return cust;
	}

	@Override
	public int update(Customer c) {
		// TODO 自动生成的方法存根
		int c1 =customerDao.update(c);
		System.out.println(c1);
		return c1;
	}

	@Override
	public Integer add(Customer c) {
		// TODO 自动生成的方法存根
		int c1=customerDao.add(c);
		return c1;
	}

	@Override
	public Integer insertemp(List<Customer> list) {
		// TODO 自动生成的方法存根
		int b=customerDao.insertemp(list);
		return b;
	}
	
	@Override
	public List<Customer> findpage(Integer Mpcounts,Integer Dpage) {
		// TODO 自动生成的方法存根
		List list=customerDao.findpage(Mpcounts,Dpage);
		return list;
	}

	@Override
	public Integer bncounts() {
		// TODO 自动生成的方法存根
		int counts=customerDao.bncounts();
		return counts;
	}

	@Override
	public Integer delete(List list) {
		// TODO 自动生成的方法存根
		int count=customerDao.delete(list);
		return count;
	}

	@Override
	public List<Customer> customerall() {
		// TODO 自动生成的方法存根
		return customerDao.customerall();
	}

	@Override
	public Integer deletefyid(Integer cust_id) {
		// TODO 自动生成的方法存根
		return customerDao.deletefyid(cust_id);
	}

	@Override
	public List<Customer> customerx() {
		// TODO 自动生成的方法存根
		return customerDao.customerx();
	}

	@Override
	public List<Customer> customerfindc(Customer cust) {
		// TODO 自动生成的方法存根
		return customerDao.customerfindc(cust);
	}

	
}
