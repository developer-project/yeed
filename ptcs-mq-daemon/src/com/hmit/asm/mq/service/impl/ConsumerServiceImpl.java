package com.hmit.asm.mq.service.impl;

import com.hmit.asm.mq.service.ConsumerService;

import eins.framework.dao.CommonHibernateDaoSupport;

public class ConsumerServiceImpl extends CommonHibernateDaoSupport implements ConsumerService {

	public void receiveMqMsg(String msg) {
		System.out.println("===111111111111111111======" + msg);
	}
	
}
