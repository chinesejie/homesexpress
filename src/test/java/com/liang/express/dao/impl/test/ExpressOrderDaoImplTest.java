package com.liang.express.dao.impl.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liang.express.pojo.ExpressOrder;
import com.liang.express.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ExpressOrderDaoImplTest {

	@Resource
	private OrderService orderService;

	@Test
	public void testGetAllOriginOrdersBySid() {
		/*ExpressOrder eo = new ExpressOrder();
		eo.setWeight(2.2);
		long l = orderService.insertOrder(eo);
		List<ExpressOrder> es = orderService.getAllUnpaidOrdersByCid(1);
		System.out.println(es.size() + "----------");*/
	}
	
	@Test
	public void testGetAllUnpaidOrders() {
		 
	}
	
}
