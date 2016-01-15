package com.hmit.asm.mq.producer;

import org.springframework.jms.core.JmsTemplate;

public abstract class AbstractJmsTemplate {

	protected JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void convertAndSend(String destination, String message) {
		this.jmsTemplate.convertAndSend(destination, message);
	}
	
}
