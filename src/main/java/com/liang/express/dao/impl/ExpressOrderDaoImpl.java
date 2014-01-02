package com.liang.express.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.liang.express.dao.ExpressCustomerDao;
import com.liang.express.dao.ExpressOrderDao;
import com.liang.express.pojo.ExpressCustomer;
import com.liang.express.pojo.ExpressOrder;

@Component
public class ExpressOrderDaoImpl implements ExpressOrderDao {
	@Resource(name = "hibernateTemplate")
	protected HibernateTemplate hibernateTemplate;

	@Override
	public List<ExpressOrder> getAllOriginOrdersBySid(long sid) {
		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.originSite_sid = " + sid);

		return eos;
	}

	@Override
	public List<ExpressOrder> getAllFinalOrdersBySid(long sid) {
		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.finalSite_sid = " + sid);

		return eos;
	}

	@Override
	public ExpressOrder getOrderByOid(long oid) {
		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.oid = " + oid);

		return eos.size() > 0 ? eos.get(0) : null;
	}

	@Override
	public long insertOrder(ExpressOrder expressOrder) {

		long oid = (Long) hibernateTemplate.save(expressOrder);
		return oid;
	}

	// 更新状态
	@Override
	public boolean updateStatusByOid(ExpressOrder order, int status) {
		// TODO Auto-generated method stub
		try {
			order.setStatus(status);
			hibernateTemplate.saveOrUpdate(order);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public boolean deleteOrderByOid(long oid) {
		ExpressOrder eo = getOrderByOid(oid);
		if (eo != null) {
			eo.setCancel(true);
			// hibernateTemplate.saveOrUpdate(eo);
			hibernateTemplate.delete(eo);
			return true;
		}
		return false;
	}

	@Override
	public List<ExpressOrder> getAllUnpaidOrdersByCid(long cid) {
		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.expressCustomer = " + cid + " and expressOrder.paid=0 ");

		return eos;
	}

	@Override
	public List<ExpressOrder> getAllTransportingOrdersByCid(long cid) {

		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.expressCustomer = " + cid + " and expressOrder.status>-1 and  expressOrder.status <4 ");

		return eos;
	}

	@Override
	public List<ExpressOrder> getAllTransportedOrdersByCid(long cid) {
		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.expressCustomer = " + cid + " and expressOrder.status=4");

		return eos;
	}

	@Override
	public List<ExpressOrder> getAllUntransportingOrdersByCid(long cid) {
		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.expressCustomer = " + cid + " and expressOrder.status=-1");

		return eos;
	}

	@Override
	public boolean updatePaidByOid(ExpressOrder order) {
		double money = order.getExpressCustomer().getMoney();
		order.getExpressCustomer().setMoney(money - 10); // 每单 10快。
		try {
			hibernateTemplate.saveOrUpdate(order);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public List<ExpressOrder> getAllpaidOrdersByCid(long cid) {
		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.expressCustomer = " + cid + " and expressOrder.paid=1");

		return eos;
	}

	@Override
	public List<ExpressOrder> getAllOriginOrdersWaitingGetBySid(long sid) {
		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.originSite = " + sid + " and expressOrder.status=-1");

		return eos;
	}

	@Override
	public List<ExpressOrder> getAllOriginOrdersWaitingFlushBySid(long sid) {
		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.originSite = " + sid + " and expressOrder.status= 0");

		return eos;

	}

	@Override
	public List<ExpressOrder> getAllFinalOrdersWaitingArriveBySid(long sid) {
		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.finalSite = " + sid + " and expressOrder.status=1");

		return eos;
	}



	@Override
	public List<ExpressOrder> getAllFinalOrdersWaitingSendBySid(long sid) {
		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.finalSite = " + sid + " and expressOrder.status=2");

		return eos;
	}
	
	@Override
	public List<ExpressOrder> getAllFinalOrdersWaitingSignBySid(long sid) {
		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.finalSite = " + sid + " and expressOrder.status=3");

		return eos;
	}

	@Override
	public List<ExpressOrder> getAllFinalOrdersHasSignBySid(long sid) {
		List<ExpressOrder> eos = (List<ExpressOrder>) hibernateTemplate.find("from ExpressOrder expressOrder where expressOrder.finalSite = " + sid + " and expressOrder.status=4");

		return eos;
	}

	@Override
	public boolean updateBo(ExpressOrder order) {
		try {
			hibernateTemplate.update(order);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
