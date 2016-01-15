package com.hmit.asm.mq.consumber.service;

import com.hmit.asm.mq.IbmMqReceiveRecord;

public interface ConsumberOrderService {

	public void consumberOrder(IbmMqReceiveRecord record);
	
}
