package com.liang.express.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liang.express.dao.WeixinMessageDao;
import com.liang.express.pojo.WeixinMessage;
import com.liang.express.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private WeixinMessageDao weixinMessageDao;

	@Override
	public boolean insert(WeixinMessage wm) {
		
		return weixinMessageDao.insert(wm);
	}

}
