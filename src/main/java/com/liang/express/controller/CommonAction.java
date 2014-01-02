package com.liang.express.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.liang.express.pojo.ExpressCustomer;
import com.liang.express.pojo.ExpressSite;
import com.liang.express.service.CustomerService;
import com.liang.express.service.SiteService;

@Controller
public class CommonAction {
	@Autowired
	private SiteService siteService;

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = { "clogin.action" })
	public String clogin(HttpServletRequest request, @RequestParam String name, @RequestParam String password) {
		ExpressCustomer ec = customerService.login(name, password);
		if (ec != null) {
			request.getSession().setAttribute("adminLogined", "true");
			request.getSession().setAttribute("currentUser", ec);// sina app放入object 问题很大。。
			request.getSession().setAttribute("userName", ec.getName());

			return "redirect:customer/quickOrderShow.action";
		} else {
			return "index";
		}

	}

	@RequestMapping(value = { "slogin.action" })
	public String slogin(HttpServletRequest request, @RequestParam String name, @RequestParam String password,@RequestParam String code) {
		if (!(code.equalsIgnoreCase(request.getSession().getAttribute("code").toString()))) {
			return "adminSignin";
		}
		
		
		ExpressSite ec = siteService.login(name, password);
		if (ec != null) {
			request.getSession().setAttribute("adminLogined", "true");
			request.getSession().setAttribute("currentUser", ec);

			return "redirect:manager/gettingExpress.action";
		} else {
			return "adminSignin";
		}
	}
}
