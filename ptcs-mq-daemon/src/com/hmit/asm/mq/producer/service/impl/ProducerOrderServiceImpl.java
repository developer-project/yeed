package com.hmit.asm.mq.producer.service.impl;

import com.hmit.asm.mq.producer.AbstractJmsTemplate;
import com.hmit.asm.mq.producer.service.ProducerOrderService;

import eins.framework.util.StringUtils;

public class ProducerOrderServiceImpl extends AbstractJmsTemplate implements ProducerOrderService {
	
	private String producerQueueDestination;

	@Override
	public void producerOrder() {
		if (!StringUtils.hasText(producerQueueDestination)) {
			throw new IllegalArgumentException("没有指定消息队列名称[Destination]");
		}
		
		System.out.println("发送：===start===");
		super.convertAndSend(producerQueueDestination, "测试数据， 欢迎使用IBM WebSphere MQ");
		System.out.println("发送：===end===");
	}

	public void setProducerQueueDestination(String producerQueueDestination) {
		this.producerQueueDestination = producerQueueDestination;
	}
}
