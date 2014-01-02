package com.liang.express.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.liang.express.dao.ExpressCustomerDao;
import com.liang.express.dao.ExpressSiteDao;
import com.liang.express.pojo.ExpressCustomer;
import com.liang.express.pojo.ExpressOrder;
import com.liang.express.pojo.ExpressSite;

@Component
public class ExpressSiteDaoImpl implements ExpressSiteDao {
	@Resource(name = "hibernateTemplate")
	protected HibernateTemplate hibernateTemplate;

	@Override
	public List<ExpressSite> getAllSites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpressSite login(String name, String password) {
		List<ExpressSite> expressSites = (List<ExpressSite>) hibernateTemplate.find("from ExpressSite expressSite where expressSite.name='" + name + "' and expressSite.password='" + password + "'");

		return expressSites.size() > 0 ? expressSites.get(0) : null;
	}

	@Override
	public long getSidByName(String name) {
		List<ExpressSite> expressSites = (List<ExpressSite>) hibernateTemplate.find("from ExpressSite expressSite where expressSite.name='" + name+"'");

		return expressSites.size() > 0 ? expressSites.get(0).getSid() : 0;
	}

	@Override
	public ExpressSite getSiteByName(String name) {
		List<ExpressSite> expressSites = (List<ExpressSite>) hibernateTemplate.find("from ExpressSite expressSite where expressSite.name='" + name+"'");

		return expressSites.size() > 0 ? expressSites.get(0) : null;
	}

}
