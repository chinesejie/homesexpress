package com.liang.express.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.liang.express.dao.ExpressCustomerDao;
import com.liang.express.pojo.ExpressCustomer;

@Component
public class ExpressCustomerDaoImpl implements ExpressCustomerDao {
	@Resource(name = "hibernateTemplate")
	protected HibernateTemplate hibernateTemplate;

	@Override
	public List<ExpressCustomer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<ExpressCustomer> list = (List<ExpressCustomer>) hibernateTemplate.find("from ExpressCustomer expressCustomer");
		return list;
	}

	@Override
	public ExpressCustomer login(String name, String password) {
		List<ExpressCustomer> expressCustomers = (List<ExpressCustomer>) hibernateTemplate.find("from ExpressCustomer expressCustomer where expressCustomer.name='" + name + "' and expressCustomer.password='" + password + "'");

		return expressCustomers.size() > 0 ? expressCustomers.get(0) : null;
	}

	@Override
	public ExpressCustomer getAccount(long cid) {
		List<ExpressCustomer> expressCustomers = (List<ExpressCustomer>) hibernateTemplate.find("from ExpressCustomer expressCustomer where expressCustomer.cid=" + cid);

		return expressCustomers != null ? expressCustomers.get(0) : null;
	}

	@Override
	public boolean updateAccount(ExpressCustomer expressCustomer) {
		try {
			hibernateTemplate.update(expressCustomer);
			return true;
		} catch (Exception e) {

			return false;
		}
	}
}
