package com.liang.express.dao.impl.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liang.express.pojo.ExpressOrder;
import com.liang.express.pojo.ExpressSite;
import com.liang.express.service.OrderService;
import com.liang.express.service.SiteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ExpressSiteDaoImplTest {

	@Resource
	private SiteService siteService;

	@Test
	public void testLogin() {
	/*	ExpressSite es = siteService.login("site", "1");
		System.out.println(es.getSid());*/
	}
}
