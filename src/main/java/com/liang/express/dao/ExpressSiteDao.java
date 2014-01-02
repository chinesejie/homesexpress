package com.liang.express.dao;

import java.util.List;

import com.liang.express.pojo.ExpressCustomer;
import com.liang.express.pojo.ExpressSite;

public interface ExpressSiteDao {
	public List<ExpressSite> getAllSites();

	public ExpressSite login(String name, String password);

	public long getSidByName(String name);

	public ExpressSite getSiteByName(String name);
}
