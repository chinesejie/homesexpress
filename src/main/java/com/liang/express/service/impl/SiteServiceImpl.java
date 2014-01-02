package com.liang.express.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liang.express.dao.ExpressCustomerDao;
import com.liang.express.dao.ExpressSiteDao;
import com.liang.express.pojo.ExpressCustomer;
import com.liang.express.pojo.ExpressSite;
import com.liang.express.service.CustomerService;
import com.liang.express.service.SiteService;

@Service
public class SiteServiceImpl implements SiteService {

	@Autowired
	private ExpressSiteDao expressSiteDao;

	@Override
	public List<ExpressSite> getAllSites() {

		return null;
	}

	@Override
	public ExpressSite getSiteById(long sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpressSite login(String name, String password) {
		// TODO Auto-generated method stub
		return expressSiteDao.login(name, password);
	}

	@Override
	public long getSidByName(String name) {
		// TODO Auto-generated method stub
		return expressSiteDao.getSidByName(name);
	}

	@Override
	public ExpressSite getSiteByName(String name) {
		// TODO Auto-generated method stub
		return expressSiteDao.getSiteByName(name);
	}

}
