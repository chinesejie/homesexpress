package com.liang.express.dao;

import java.util.List;

import com.liang.express.pojo.ExpressCustomer;

public interface ExpressCustomerDao {
	public List<ExpressCustomer> getAllCustomers();

	public ExpressCustomer login(String name, String password);

	public ExpressCustomer getAccount(long cid);

	public boolean updateAccount(ExpressCustomer expressCustomer);
}
