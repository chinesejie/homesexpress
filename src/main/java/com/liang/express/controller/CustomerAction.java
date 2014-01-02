package com.liang.express.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liang.action.SignUtil;
import com.liang.express.pojo.ExpressCustomer;
import com.liang.express.pojo.ExpressOrder;
import com.liang.express.service.CommonService;
import com.liang.express.service.CustomerService;
import com.liang.express.service.OrderService;
import com.liang.express.service.SiteService;

@Controller
@RequestMapping("customer")
public class CustomerAction {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private SiteService siteService;

	// @RequestMapping(value = { "all.action" })
	// public String postNew(String content, String title,
	// @RequestParam(required = false) MultipartFile file1, HttpServletRequest
	// request, HttpServletResponse response, HttpSession session) {
	// List<ExpressCustomer> customers = customerService.getAllCustomers();
	//
	// return customers.get(0).getName();
	// }
	//
	// @RequestMapping(value = { "one.action" })
	// public String one(Map<String, Object> map) {
	// List<ExpressCustomer> customers = customerService.getAllCustomers();
	// map.put("one", customers.get(0).getName());
	// return "customer/one";
	// }
	public long getSidByName(String name) {
		return siteService.getSidByName(name);
	}

	/**
	 * 快捷下单的界面
	 * 
	 * 无处理逻辑，直接显示操作界面
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "quickOrderShow.action" })
	public String quickOrderShow() {
		return "customer/quickOrderShow";
	}

	/**
	 * 
	 * @param request
	 * @param senderName
	 * @param senderPhone
	 * @param senderProvince
	 * @param senderCity
	 * @param senderTown
	 * @param senderAddress
	 * @param receiverName
	 * @param receiverPhone
	 * @param receiverProvince
	 * @param receiverCity
	 * @param receiverTown
	 * @param receiverAddress
	 * @param weight
	 * @param note
	 * @return
	 */
	@RequestMapping(value = { "quickOrderCommit.action" })
	public String quickOrderCommit(HttpServletRequest request, @RequestParam String senderName, @RequestParam String senderNumber, @RequestParam String senderProvince, @RequestParam String senderCity, @RequestParam String senderTown, @RequestParam String senderAddress, @RequestParam String receiverName, @RequestParam String receiverNumber, @RequestParam String receiverProvince, @RequestParam String receiverCity, @RequestParam String receiverTown, @RequestParam String receiverAddress, @RequestParam double weight, @RequestParam String note) {
		if (!checkUser(request)) {
			return "error";
		}
		HttpSession session = request.getSession();
		// 处理下单的逻辑。。
		ExpressOrder expressOrder = new ExpressOrder();
		expressOrder.setNote(note);
		expressOrder.setExpressCustomer((ExpressCustomer) session.getAttribute("currentUser"));
		expressOrder.setReceiverAddress(receiverProvince + " " + receiverCity + " " + receiverTown + " " + receiverAddress);
		expressOrder.setReceiverName(receiverName);
		expressOrder.setReceiverNumber(receiverNumber);

		expressOrder.setSenderAddress(senderProvince + " " + senderCity + " " + senderTown + " " + senderAddress);
		expressOrder.setSenderName(senderName);
		expressOrder.setSenderNumber(senderNumber);

		expressOrder.setWeight(weight);
		// expressOrder.setStatus(-1);//
		// -1表示未收件，0表示已收件+待发件（标明收件站点），1表示已发件+未到件（标明下一站），2表示已到件+待派件（标明到件站点），3表示已派件+未签收，4表示已签收
		expressOrder.setPaid(false);// 未支付
		expressOrder.setCancel(false);
		expressOrder.setStatus(-2);// 还没给钱
		expressOrder.setOrderTime(new Date());
		expressOrder.setOriginSite(siteService.getSiteByName(senderProvince));
		expressOrder.setFinalSite(siteService.getSiteByName(receiverProvince));
		long oid = orderService.insertOrder(expressOrder);

		return "redirect:quickOrderPaidShow.action?oid=" + oid;
	}

	/**
	 * 展示页面，问他要不要支付
	 * 
	 * @param request
	 * @param oid
	 * @return
	 */
	@RequestMapping(value = { "quickOrderPaidShow.action" }, method = RequestMethod.GET)
	public String quickOrderPaid(HttpServletRequest request, @RequestParam long oid, Map<String, Object> map) {

		map.put("quickOrder", orderService.getOrderByOid(oid));
		return "customer/quickOrderPaidShow";
	}

	/**
	 * 支付的请求
	 * 
	 * @param request
	 * @param oid
	 * @return
	 */
	@RequestMapping(value = { "quickOrderPaidCommit.action" }, produces = { "text/javascript;charset=UTF-8" })
	@ResponseBody
	public String quickOrderPaidCommit(HttpServletRequest request, @RequestParam long oid, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressCustomer ec = (ExpressCustomer) request.getSession().getAttribute("currentUser");

		ExpressOrder eo = orderService.getOrderByOid(oid);
		eo.setPaid(true);
		eo.setPrice(15);
		eo.setStatus(-1);// 进入未发货状态
		// 写入

		orderService.updatePaidByOid(eo);
		ec.setMoney(ec.getMoney() - 15);
		customerService.updateAccount(ec);
		return "success";
	}

	/**
	 * 撤销的请求
	 * 
	 * 用于ajax
	 * 
	 * @param request
	 * @param oid
	 * @return
	 */
	@RequestMapping(value = { "quickOrderPaidCancel.action" })
	@ResponseBody
	public String quickOrderPaidCancel(HttpServletRequest request, @RequestParam long oid, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressCustomer ec = (ExpressCustomer) request.getSession().getAttribute("currentUser");
		ExpressOrder eo = orderService.getOrderByOid(oid);
		if (eo.getExpressCustomer().getCid() != ec.getCid()) {
			// 如果订单不属于这个用户，该用户不能查看
			return "error";
		}
		orderService.deleteOrderByOid(oid);// 不会删除，只会写入撤销的标志位
		return "success";
	}

	/**
	 * 未支付的订单
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "unpaidOrders.action" })
	public String unpaidOrders(HttpServletRequest request, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressCustomer ec = (ExpressCustomer) request.getSession().getAttribute("currentUser");

		//
		map.put("unpaidOrders", orderService.getAllUnpaidOrdersByCid(ec.getCid()));
		return "customer/unpaidOrders";
	}

	/**
	 * 支付的订单
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "paidOrders.action" })
	public String paidOrders(HttpServletRequest request, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressCustomer ec = (ExpressCustomer) request.getSession().getAttribute("currentUser");

		//
		map.put("paidOrders", orderService.getAllpaidOrdersByCid(ec.getCid()));
		return "customer/paidOrders";
	}

	/**
	 * 支付的订单 详情
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "paidOrder.action" })
	public String paidOrder(HttpServletRequest request, @RequestParam long oid, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressCustomer ec = (ExpressCustomer) request.getSession().getAttribute("currentUser");
		ExpressOrder eo = orderService.getOrderByOid(oid);
		if (eo.getExpressCustomer().getCid() != ec.getCid()) {
			// 如果订单不属于这个用户，该用户不能查看
			return "error";
		}
		map.put("quickOrder", eo);
		return "customer/paidOrder";
	}

	/**
	 * 根据oid 得到订单 先检查登录，然后 获取
	 * 
	 * @param oid
	 * @return
	 */
	@RequestMapping(value = { "unpaidOrder.action" })
	public String unpaidOrder(HttpServletRequest request, @RequestParam long oid, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressCustomer ec = (ExpressCustomer) request.getSession().getAttribute("currentUser");
		ExpressOrder eo = orderService.getOrderByOid(oid);
		if (eo.getExpressCustomer().getCid() != ec.getCid()) {
			// 如果订单不属于这个用户，该用户不能查看
			return "error";
		}
		map.put("quickOrder", eo);
		return "customer/unpaidOrder";
	}

	/**
	 * 查看进行中的运单。。状态>-1 并且 <4
	 * 
	 * @param oid
	 * @return
	 */
	@RequestMapping(value = { "transportingOrders.action" })
	public String transportingOrders(HttpServletRequest request, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressCustomer ec = (ExpressCustomer) request.getSession().getAttribute("currentUser");
		map.put("transportingOrders", orderService.getAllTransportingOrdersByCid(ec.getCid()));
		return "customer/transportingOrders";
	}

	/**
	 * 根据oid 得到订单 先检查登录，然后 获取
	 * 
	 * 根据不同的状态 显示 timeline
	 * 
	 * @param oid
	 * @return
	 */
	@RequestMapping(value = { "transportingOrder.action" })
	public String transportingOrders(HttpServletRequest request, @RequestParam long oid, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressCustomer ec = (ExpressCustomer) request.getSession().getAttribute("currentUser");
		ExpressOrder eo = orderService.getOrderByOid(oid);
		if (eo.getExpressCustomer().getCid() != ec.getCid()) {
			// 如果订单不属于这个用户，该用户不能查看
			return "error";
		}
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < eo.getStatus() + 1; i++) {
			Map<String, Object> m = new HashMap<String, Object>();
			if (i == 0) {
				m.put("time", eo.getGetTime());
				m.put("what", "快件已由"+eo.getOriginSite().getName()+"站点接收");
			}
			if (i == 1) {
				m.put("time", eo.getFlushTime());
				m.put("what", "快件已从"+eo.getOriginSite().getName()+"出发，发往"+eo.getFinalSite().getName());
			}
			if (i == 2) {
				m.put("time", eo.getArriveTime());
				m.put("what", "快件已由"+eo.getFinalSite().getName()+"站点揽入");
			}
			if (i == 3) {
				m.put("time", eo.getSendTime());
				m.put("what", "快件已由"+eo.getFinalSite().getName()+"站点派送中");
			}
			list.add(m);
		}

		map.put("transportingOrder", list);
		map.put("oid", eo.getOid() );
		return "customer/transportingOrder";
	}

	/**
	 * 查看 的运单。。
	 * 
	 * @param oid
	 * @return
	 */
	@RequestMapping(value = { "transportedOrders.action" })
	public String transportedOrders(HttpServletRequest request, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressCustomer ec = (ExpressCustomer) request.getSession().getAttribute("currentUser");
		map.put("transportedOrders", orderService.getAllTransportedOrdersByCid(ec.getCid()));
		return "customer/transportedOrders";
	}

	/**
	 * 根据oid 得到订单 先检查登录，然后 获取
	 * 
	 * @param oid
	 * @return
	 */
	@RequestMapping(value = { "transportedOrder.action" })
	public String transportedOrder(HttpServletRequest request, @RequestParam long oid, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressCustomer ec = (ExpressCustomer) request.getSession().getAttribute("currentUser");
		ExpressOrder eo = orderService.getOrderByOid(oid);
		if (eo.getExpressCustomer().getCid() != ec.getCid()) {
			// 如果订单不属于这个用户，该用户不能查看
			return "error";
		}
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < eo.getStatus() + 1; i++) {
			Map<String, Object> m = new HashMap<String, Object>();
			if (i == 0) {
				m.put("time", eo.getGetTime());
				m.put("what", "快件已由"+eo.getOriginSite().getName()+"站点接收");
			}
			if (i == 1) {
				m.put("time", eo.getFlushTime());
				m.put("what", "快件已从"+eo.getOriginSite().getName()+"出发，发往"+eo.getFinalSite().getName());
			}
			if (i == 2) {
				m.put("time", eo.getArriveTime());
				m.put("what", "快件已由"+eo.getFinalSite().getName()+"站点揽入");
			}
			if (i == 3) {
				m.put("time", eo.getSendTime());
				m.put("what", "快件已由"+eo.getFinalSite().getName()+"站点派送中");
			}
			if (i == 4) {
				m.put("time", eo.getSignTime());
				m.put("what", "快件已由"+eo.getReceiverName()+"签收");
			}
			list.add(m);
		}

		map.put("transportedOrder", list);
		map.put("oid", eo.getOid() );
		return "customer/transportedOrder";
	}

	/**
	 * 查看 的运单。。
	 * 
	 * @param oid
	 * @return
	 */
	@RequestMapping(value = { "untransportingOrders.action" })
	public String untransportingOrders(HttpServletRequest request, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressCustomer ec = (ExpressCustomer) request.getSession().getAttribute("currentUser");
		map.put("untransportingOrders", orderService.getAllUntransportingOrdersByCid(ec.getCid()));
		return "customer/untransportingOrders";
	}

	/**
	 * 根据oid 得到订单 先检查登录，然后 获取
	 * 
	 * @param oid
	 * @return
	 */
	@RequestMapping(value = { "untransportingOrder.action" })
	public String untransportingOrder(HttpServletRequest request, @RequestParam long oid, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressCustomer ec = (ExpressCustomer) request.getSession().getAttribute("currentUser");
		ExpressOrder eo = orderService.getOrderByOid(oid);
		if (eo.getExpressCustomer().getCid() != ec.getCid()) {
			// 如果订单不属于这个用户，该用户不能查看
			return "error";
		}
		map.put("untransportingOrder", eo);
		return "customer/untransportingOrder";
	}

	/**
	 * 查看余额
	 * 
	 * @param oid
	 * @return
	 */
	@RequestMapping(value = { "accountShow.action" })
	public String accountShow(HttpServletRequest request, Map<String, Object> map) {

		return "customer/accountShow";
	}

	/**
	 * 根据oid 得到订单 先检查登录，然后 获取
	 * 
	 * @param oid
	 * @return
	 */
	@RequestMapping(value = { "accountAdd.action" })
	public String accountAdd(HttpServletRequest request, Map<String, Object> map) {

		return "customer/accountAdd";
	}

	public boolean checkUser(HttpServletRequest request) {
		// HttpSession session = ServletActionContext.getRequest().getSession();
		HttpSession session = request.getSession();
		String adminLogined = (String) session.getAttribute("adminLogined");
		if (adminLogined == null || !adminLogined.trim().equals("true")) {

			return false;
		} else {
			ExpressCustomer ec = (ExpressCustomer) session.getAttribute("currentUser");
			// setUser(userDAO.findUserByName(currentUser));
			if (ec == null) {
				return false;
			} else {
				return true;
			}
		}
	}
	
	@RequestMapping(value = { "coreServlet.action" },method=RequestMethod.GET)
	@ResponseBody
	public String doWeixinGet(HttpServletRequest request,HttpServletResponse response) {
		
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			return echostr;
		} else{
			return "idonotknow";
		}
		 
		
	}
	@RequestMapping(value = { "coreServlet.action" },method=RequestMethod.POST)
	@ResponseBody
	public String doWeixinPost() {
		return null;
	}
}
