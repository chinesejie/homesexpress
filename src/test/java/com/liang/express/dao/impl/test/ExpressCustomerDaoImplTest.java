package com.liang.express.dao.impl.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liang.express.pojo.ExpressCustomer;
import com.liang.express.pojo.ExpressOrder;
import com.liang.express.service.CustomerService;
import com.liang.express.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ExpressCustomerDaoImplTest {

	@Resource
	private CustomerService customerService;

	@Test
	public void testLogin() {
		//ExpressCustomer ec = customerService.login("wo", "1");
		//System.out.println(ec.getCid());
	}
}
