package com.systop.dao;

import java.util.List;

import com.systop.pojo.Basedict;

public interface BasedictMapper{
	public List<Basedict> basedictsfrom();
	public List<Basedict> basedictsindust();
	public List<Basedict> basedictslevel();
}
