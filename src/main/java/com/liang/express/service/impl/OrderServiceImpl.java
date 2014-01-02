package com.liang.express.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liang.express.dao.ExpressOrderDao;
import com.liang.express.pojo.ExpressOrder;
import com.liang.express.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ExpressOrderDao expressOrderDao;

	@Override
	public List<ExpressOrder> getAllOriginOrdersBySid(long sid) {
		return expressOrderDao.getAllOriginOrdersBySid(sid);
	}

	@Override
	public List<ExpressOrder> getAllFinalOrdersBySid(long sid) {
		return expressOrderDao.getAllFinalOrdersBySid(sid);
	}

	@Override
	public ExpressOrder getOrderByOid(long oid) {
		return expressOrderDao.getOrderByOid(oid);
	}

	@Override
	public long insertOrder(ExpressOrder expressOrder) {
		return expressOrderDao.insertOrder(expressOrder);
	}

	// .更新状态
	@Override
	public boolean updateStatusByOid(ExpressOrder order, int status) {
		return expressOrderDao.updateStatusByOid(order, status);
	}

	@Override
	public boolean deleteOrderByOid(long oid) {

		return expressOrderDao.deleteOrderByOid(oid);
	}

	@Override
	public List<ExpressOrder> getAllUnpaidOrdersByCid(long cid) {
		return expressOrderDao.getAllUnpaidOrdersByCid(cid);
	}

	@Override
	public List<ExpressOrder> getAllTransportingOrdersByCid(long cid) {
		return expressOrderDao.getAllTransportingOrdersByCid(cid);
	}

	@Override
	public List<ExpressOrder> getAllTransportedOrdersByCid(long cid) {
		return expressOrderDao.getAllTransportedOrdersByCid(cid);
	}

	@Override
	public List<ExpressOrder> getAllUntransportingOrdersByCid(long cid) {
		return expressOrderDao.getAllUntransportingOrdersByCid(cid);
	}

	@Override
	public boolean updatePaidByOid(ExpressOrder order) {
		return expressOrderDao.updatePaidByOid(order);
	}

	@Override
	public List<ExpressOrder> getAllpaidOrdersByCid(long cid) {
		return expressOrderDao.getAllpaidOrdersByCid(cid);
	}

	@Override
	public List<ExpressOrder> getAllOriginOrdersWaitingGetBySid(long sid) {

		return expressOrderDao.getAllOriginOrdersWaitingGetBySid(sid);
	}

	@Override
	public List<ExpressOrder> getAllOriginOrdersWaitingFlushBySid(long sid) {
		return expressOrderDao.getAllOriginOrdersWaitingFlushBySid(sid);
	}

	@Override
	public List<ExpressOrder> getAllFinalOrdersWaitingArriveBySid(long sid) {
		return expressOrderDao.getAllFinalOrdersWaitingArriveBySid(sid);
	}

	@Override
	public List<ExpressOrder> getAllFinalOrdersWaitingSendBySid(long sid) {
		return expressOrderDao.getAllFinalOrdersWaitingSendBySid(sid);
	}

	@Override
	public List<ExpressOrder> getAllFinalOrdersWaitingSignBySid(long sid) {
		return expressOrderDao.getAllFinalOrdersWaitingSignBySid(sid);
	}

	@Override
	public List<ExpressOrder> getAllFinalOrdersHasSignBySid(long sid) {
		return expressOrderDao.getAllFinalOrdersHasSignBySid(sid);
	}

	@Override
	public boolean updateBo(ExpressOrder order) {

		return expressOrderDao.updateBo(order);
	}

}
