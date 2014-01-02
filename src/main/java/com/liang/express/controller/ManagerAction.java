package com.liang.express.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liang.express.pojo.ExpressCustomer;
import com.liang.express.pojo.ExpressOrder;
import com.liang.express.pojo.ExpressSite;
import com.liang.express.service.CommonService;
import com.liang.express.service.CustomerService;
import com.liang.express.service.OrderService;
import com.liang.express.service.SiteService;

@Controller
@RequestMapping("manager")
public class ManagerAction {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private SiteService siteService;

	/**
	 * 待收件
	 * 
	 * @return
	 */
	@RequestMapping(value = { "gettingExpress.action" })
	public String gettingExpress(HttpServletRequest request, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressSite es = (ExpressSite) request.getSession().getAttribute("currentUser");
		map.put("express", orderService.getAllOriginOrdersWaitingGetBySid(es.getSid()));
		return "manager/gettingExpress";
	}
	
	/**
	 * 收件...状态递增
	 * 
	 * @return
	 */
	@RequestMapping(value = { "getExpress.action" })
	@ResponseBody
	public String getExpress(HttpServletRequest request, @RequestParam long oid, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressSite es = (ExpressSite) request.getSession().getAttribute("currentUser");
		ExpressOrder eo = orderService.getOrderByOid(oid);
		if(eo!=null && eo.getOriginSite().getSid()==es.getSid()){
			 eo.setStatus(eo.getStatus()+1);
			 eo.setGetTime(new Date());// 收件时间
			 
			 orderService.updateBo(eo);
		}
		else {
			return "error";
		}
		return "success";
	}

	/**
	 *  ..状态递增
	 * 
	 * @return
	 */
	@RequestMapping(value = { "flushExpress.action" })
	@ResponseBody
	public String flushExpress(HttpServletRequest request, @RequestParam long oid, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressSite es = (ExpressSite) request.getSession().getAttribute("currentUser");
		ExpressOrder eo = orderService.getOrderByOid(oid);
		if(eo!=null && eo.getOriginSite().getSid()==es.getSid()){
			 eo.setStatus(eo.getStatus()+1);
			 eo.setFlushTime(new Date());// 发件时间
			 
			 orderService.updateBo(eo);
		}
		else {
			return "error";
		}
		return "success";
	}

	/**
	 *  ..状态递增
	 * 
	 * @return
	 */
	@RequestMapping(value = { "arriveExpress.action" })
	@ResponseBody
	public String arriveExpress(HttpServletRequest request, @RequestParam long oid, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressSite es = (ExpressSite) request.getSession().getAttribute("currentUser");
		ExpressOrder eo = orderService.getOrderByOid(oid);
		if(eo!=null && eo.getFinalSite().getSid()==es.getSid()){
			 eo.setStatus(eo.getStatus()+1);
			 eo.setArriveTime(new Date());// 发件时间
			 
			 orderService.updateBo(eo);
		}
		else {
			return "error";
		}
		return "success";
	}
	/**
	 *  ..状态递增
	 * 
	 * @return
	 */
	@RequestMapping(value = { "sendExpress.action" })
	@ResponseBody
	public String sendExpress(HttpServletRequest request, @RequestParam long oid, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressSite es = (ExpressSite) request.getSession().getAttribute("currentUser");
		ExpressOrder eo = orderService.getOrderByOid(oid);
		if(eo!=null && eo.getFinalSite().getSid()==es.getSid()){
			 eo.setStatus(eo.getStatus()+1);
			 eo.setSendTime(new Date());// 发件时间
			 
			 orderService.updateBo(eo);
		}
		else {
			return "error";
		}
		return "success";
	}
	
	/**
	 *  ..状态递增
	 * 
	 * @return
	 */
	@RequestMapping(value = { "signExpress.action" })
	@ResponseBody
	public String signExpress(HttpServletRequest request, @RequestParam long oid, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressSite es = (ExpressSite) request.getSession().getAttribute("currentUser");
		ExpressOrder eo = orderService.getOrderByOid(oid);
		if(eo!=null && eo.getFinalSite().getSid()==es.getSid()){
			 eo.setStatus(eo.getStatus()+1);
			 eo.setSignTime(new Date());// 发件时间
			 
			 orderService.updateBo(eo);
		}
		else {
			return "error";
		}
		return "success";
	}


	
	 
	/**
	 * 待发件
	 * 
	 * @return
	 */
	@RequestMapping(value = { "flushingExpress.action" })
	public String flushingExpress(HttpServletRequest request, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressSite es = (ExpressSite) request.getSession().getAttribute("currentUser");
		map.put("express", orderService.getAllOriginOrdersWaitingFlushBySid(es.getSid()));
		return "manager/flushingExpress";
	}
	
	/**
	 * 待发件
	 * 
	 * @return
	 */
	@RequestMapping(value = { "arrivingExpress.action" })
	public String arrivingExpress(HttpServletRequest request, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressSite es = (ExpressSite) request.getSession().getAttribute("currentUser");
		map.put("express", orderService.getAllFinalOrdersWaitingArriveBySid(es.getSid()));
		return "manager/arrivingExpress";
	}

	/**
	 * 待派件
	 * 
	 * @return
	 */
	@RequestMapping(value = { "sendingExpress.action" })
	public String sendingExpress(HttpServletRequest request, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressSite es = (ExpressSite) request.getSession().getAttribute("currentUser");
		map.put("express", orderService.getAllFinalOrdersWaitingSendBySid(es.getSid()));
		return "manager/sendingExpress";
	}

	/**
	 * 待签收
	 * 
	 * @return
	 */
	@RequestMapping(value = { "signingExpress.action" })
	public String signingExpress(HttpServletRequest request, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressSite es = (ExpressSite) request.getSession().getAttribute("currentUser");
		map.put("express", orderService.getAllFinalOrdersWaitingSignBySid(es.getSid()));
		return "manager/signingExpress";
	}
	
	/**
	 * 已经签收
	 * 
	 * @return
	 */
	@RequestMapping(value = { "finalExpress.action" })
	public String finalExpress(HttpServletRequest request, Map<String, Object> map) {
		if (!checkUser(request)) {
			return "error";
		}
		ExpressSite es = (ExpressSite) request.getSession().getAttribute("currentUser");
		map.put("express", orderService.getAllFinalOrdersHasSignBySid(es.getSid()));
		return "manager/finalExpress";
	}

	public boolean checkUser(HttpServletRequest request) {
		// HttpSession session = ServletActionContext.getRequest().getSession();
		HttpSession session = request.getSession();
		String adminLogined = (String) session.getAttribute("adminLogined");
		if (adminLogined == null || !adminLogined.trim().equals("true")) {

			return false;
		} else {
			ExpressSite ec = (ExpressSite) session.getAttribute("currentUser");
			// setUser(userDAO.findUserByName(currentUser));
			if (ec == null) {
				return false;
			} else {
				return true;
			}
		}
	}
}
