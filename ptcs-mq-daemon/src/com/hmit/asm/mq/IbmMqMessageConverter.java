package com.hmit.asm.mq;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class IbmMqMessageConverter implements MessageConverter {

	/**
	 * 接收MQ消息的转换
	 */
	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		TextMessage textMessage = (TextMessage) message; 
		IbmMqReceiveRecord record = new IbmMqReceiveRecord();
		record.setReceiveTime(new Date());
		record.setContent(textMessage.getText());
		return record;
	}

	@Override
	public Message toMessage(Object arg0, Session arg1) throws JMSException, MessageConversionException {
		// TODO Auto-generated method stub
		return null;
	}

}
