package com.liang.express.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liang.express.dao.WeixinMessageDao;
import com.liang.express.pojo.WeixinMessage;

@Component
public class WeixinMessageDaoImpl implements WeixinMessageDao {

	@Resource(name = "hibernateTemplate")
	protected HibernateTemplate hibernateTemplate;

	@Override
	public boolean insert(WeixinMessage wm) {
		try {
			hibernateTemplate.save(wm);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
