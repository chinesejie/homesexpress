package com.liang.express.service;

import java.util.List;

import com.liang.express.pojo.ExpressCustomer;

public interface CustomerService {
	public List<ExpressCustomer> getAllCustomers();

	public ExpressCustomer login(String name, String passwrod);

	public ExpressCustomer getAccount(long cid);

	public boolean updateAccount(ExpressCustomer expressCustomer);
}
