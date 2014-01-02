package com.liang.express.service;

import java.util.List;

import com.liang.express.pojo.ExpressSite;

public interface SiteService {
	// 获取所有的站点
	public List<ExpressSite> getAllSites();

	// 根据站点的id 获取 详细信息
	public ExpressSite getSiteById(long sid);

	public ExpressSite login(String name, String password);

	public long getSidByName(String name);

	public ExpressSite getSiteByName(String name);

}
