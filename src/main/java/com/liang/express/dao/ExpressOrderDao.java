package com.liang.express.dao;

import java.util.List;

import com.liang.express.pojo.ExpressOrder;

public interface ExpressOrderDao {
	// 获取站点 的所有出发件
	public List<ExpressOrder> getAllOriginOrdersBySid(long sid);

	public List<ExpressOrder> getAllOriginOrdersWaitingGetBySid(long sid);
	
	public List<ExpressOrder> getAllOriginOrdersWaitingFlushBySid(long sid);
	
	public List<ExpressOrder> getAllFinalOrdersWaitingArriveBySid(long sid);
	public List<ExpressOrder> getAllFinalOrdersWaitingSendBySid(long sid);
	public List<ExpressOrder> getAllFinalOrdersWaitingSignBySid(long sid);
	
	public List<ExpressOrder> getAllFinalOrdersHasSignBySid(long sid);

	// 获取站的所有 到达件
	public List<ExpressOrder> getAllFinalOrdersBySid(long sid);

	// 获取 快件的 具体信息
	public ExpressOrder getOrderByOid(long sid);

	// 插入快件
	public long insertOrder(ExpressOrder expressOrder);

	// 更改快件状态
	public boolean updateStatusByOid(ExpressOrder order, int status);

	// 删除快件
	public boolean deleteOrderByOid(long oid);

	// 得到 某人的所有订单。
	public List<ExpressOrder> getAllUnpaidOrdersByCid(long cid);

	// 得到 某人的所有进行中订单。
	public List<ExpressOrder> getAllTransportingOrdersByCid(long cid);

	// 得到 某人的所有结束的运单。
	public List<ExpressOrder> getAllTransportedOrdersByCid(long cid);

	// 得到 某人的所有未开始的订单。
	public List<ExpressOrder> getAllUntransportingOrdersByCid(long cid);

	// 更新支付。。
	public boolean updatePaidByOid(ExpressOrder order);

	public List<ExpressOrder> getAllpaidOrdersByCid(long cid);
	
	public boolean updateBo(ExpressOrder order);
}
