package com.systop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.systop.pojo.Interview;

public interface InterviewMapper {
	public Interview uionselect(@Param("inter_cust_id")Integer inter_cust_id);
	public List<Interview> interviewall();
	public List<Interview> interselects();
	public Integer interviewadd(Interview in);
	public Interview interviewbyid(@Param("inter_cust_id")Integer inter_cust_id);
}
