package com.hmit.asm.mq.producer02;

import java.io.IOException;

import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

public class MQProducerTest {
	
	private MQQueue mqQueue;
	
	/**
	 * 接收消息
	 * @methodName com.hmit.asm.mq.producer02.MQProducerTest.getMsg
	 * @author hailiang.jiang
	 * @date 2016年1月15日 下午2:42:55
	 * @version: v1.0.0
	 */
	public void getMsg() {
		/** 接收方主机名 **/
		String hostName = "127.0.0.1";
		/** 接收方服务器连接通道 **/
		String channel = "SERVER";
		/** 接收方队列管理器名称 **/
		String qManager = "receive";
		/** 接收方队列名称 **/
		String qName = "Q2";
		
		MQEnvironment.hostname = hostName;
		MQEnvironment.channel = channel;
		MQEnvironment.CCSID = 1381;
		MQEnvironment.port = 1416;
		MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES);
		MQEnvironment.disableTracing();
		MQException.log = null;
		
		MQQueueManager qMgr = null;
		try {
			/**连接到队列管理**/
			qMgr = new MQQueueManager(qManager);
			System.out.println("成功连接QueueManager");
			int openOptions = MQC.MQOO_INPUT_SHARED | MQC.MQOO_FAIL_IF_QUIESCING;
			
			mqQueue = qMgr.accessQueue(qName, openOptions);
			
			MQGetMessageOptions gmo = new MQGetMessageOptions();
			
			MQMessage inMsg = new MQMessage();
			mqQueue.get(inMsg, gmo);
			
			String msg = inMsg.readString(inMsg.getMessageLength());
			System.out.println("thiis message is " + msg);
			qMgr.commit();
		} catch (MQException e) {
			System.out.println("Error Code: " + e.reasonCode);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (mqQueue != null) {
					mqQueue.close();
					System.out.println("成功关闭Queue");
				}
				if (qMgr != null) {
					qMgr.close();
					qMgr.disconnect();
					System.out.println("成功关闭、断开QueueManager");
				}
			} catch (MQException e) {
				e.printStackTrace();
			}
		}
	
	}

	/**
	 * 发送消息
	 * @methodName com.hmit.asm.mq.producer02.MQProducerTest.putMsg
	 * @author hailiang.jiang
	 * @date 2016年1月15日 下午2:43:05
	 * @version: v1.0.0
	 */
	public void putMsg() {
		/** 源方主机名 **/
		String hostName = "127.0.0.1";
		/** 源方服务器连接通道 **/
		String channel = "SERVER";
		/** 源方队列管理器名称 **/
		String qManager = "send";
		/** 远程队列管理器，定义远程队列管理器为receive，远程队列为Q2 **/
		String qName = "Q2";
		
		MQEnvironment.hostname = hostName;
		MQEnvironment.channel = channel;
		MQEnvironment.CCSID = 1381;
		MQEnvironment.port = 1415;
		MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES);
		MQEnvironment.disableTracing();
		MQException.log = null;
		
		MQQueueManager qMgr = null;
		try {
			/**连接到队列管理**/
			qMgr = new MQQueueManager(qManager);
			System.out.println("成功连接QueueManager");
			int openOptions = MQC.MQOO_OUTPUT | MQC.MQOO_FAIL_IF_QUIESCING;
			
			mqQueue = qMgr.accessQueue(qName, openOptions);
			
			MQPutMessageOptions mpmo = new MQPutMessageOptions();
			
			MQMessage msg = new MQMessage();
			msg.writeString(new java.util.Date().toString());
			
			mqQueue.put(msg, mpmo);
			
		} catch (MQException e) {
			System.out.println("Error Code: " + e.reasonCode);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (mqQueue != null) {
					mqQueue.close();
					System.out.println("成功关闭Queue");
				}
				if (qMgr != null) {
					qMgr.close();
					qMgr.disconnect();
					System.out.println("成功关闭、断开QueueManager");
				}
			} catch (MQException e) {
				e.printStackTrace();
			}
		}
	}
	
}
