package com.systop.pojo;

import java.util.Date;

public class Interview {
	private Integer inter_id;
	private Integer inter_cust_id;
	private Integer inter_user_id;
	private String inter_record;
	private Date inter_datetime;
	public Customer customer;
	public UserLogin userlogin;
	public Integer getInter_id() {
		return inter_id;
	}
	public void setInter_id(Integer inter_id) {
		this.inter_id = inter_id;
	}
	public Integer getInter_cust_id() {
		return inter_cust_id;
	}
	public void setInter_cust_id(Integer inter_cust_id) {
		this.inter_cust_id = inter_cust_id;
	}
	public Integer getInter_user_id() {
		return inter_user_id;
	}
	public void setInter_user_id(Integer inter_user_id) {
		this.inter_user_id = inter_user_id;
	}
	public String getInter_record() {
		return inter_record;
	}
	public void setInter_record(String inter_record) {
		this.inter_record = inter_record;
	}
	public Date getInter_datetime() {
		return inter_datetime;
	}
	public void setInter_datetime(Date inter_datetime) {
		this.inter_datetime = inter_datetime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public UserLogin getUserlogin() {
		return userlogin;
	}
	public void setUserlogin(UserLogin userlogin) {
		this.userlogin = userlogin;
	}
	@Override
	public String toString() {
		return "Interview [inter_id=" + inter_id + ", inter_cust_id=" + inter_cust_id + ", inter_user_id="
				+ inter_user_id + ", inter_record=" + inter_record + ", inter_datetime=" + inter_datetime
				+ ", customer=" + customer + ", userlogin=" + userlogin + "]";
	}
	
	
	
	
	
	
	
	
}
