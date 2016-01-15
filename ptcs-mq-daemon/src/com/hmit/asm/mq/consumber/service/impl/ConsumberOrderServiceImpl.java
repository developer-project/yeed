package com.hmit.asm.mq.consumber.service.impl;

import com.hmit.asm.mq.IbmMqReceiveRecord;
import com.hmit.asm.mq.consumber.service.ConsumberOrderService;

public class ConsumberOrderServiceImpl implements ConsumberOrderService {

	@Override
	public void consumberOrder(IbmMqReceiveRecord record) {
		System.out.println("消费者：" + record.getContent());
		
	}

}
