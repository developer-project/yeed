package com.hmit.asm.mq;

import java.io.Serializable;
import java.util.Date;

import com.ibm.jms.JMSTextMessage;

@SuppressWarnings("deprecation")
public class IbmMqReceiveRecord extends JMSTextMessage implements Serializable {
	private static final long serialVersionUID = 58284115947059864L;
	
	private String content;
	private Date receiveTime;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

}
