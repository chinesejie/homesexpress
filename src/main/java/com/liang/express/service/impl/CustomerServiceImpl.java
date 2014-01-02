package com.liang.express.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liang.express.dao.ExpressCustomerDao;
import com.liang.express.pojo.ExpressCustomer;
import com.liang.express.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private ExpressCustomerDao expressCustomerDao;

	@Override
	public List<ExpressCustomer> getAllCustomers() {
		return expressCustomerDao.getAllCustomers();
	}

	@Override
	public ExpressCustomer login(String name, String password) {

		return expressCustomerDao.login(name, password);
	}

	@Override
	public ExpressCustomer getAccount(long cid) {
		// TODO Auto-generated method stub
		return expressCustomerDao.getAccount(cid);
	}

	@Override
	public boolean updateAccount(ExpressCustomer expressCustomer) {
		// TODO Auto-generated method stub
		return expressCustomerDao.updateAccount(expressCustomer);
	}

}
