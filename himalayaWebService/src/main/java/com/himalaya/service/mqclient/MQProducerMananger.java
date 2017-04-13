package com.himalaya.service.mqclient;

import org.apache.cxf.binding.soap.interceptor.StartBodyInterceptor;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.sun.xml.bind.v2.TODO;

public class MQProducerMananger {
	
	private DefaultMQProducer defaultProducer = null;
	
	/**
	 * How to start RocketMQ
	 * doubleclick mqnamesrv
	 * run mqbroker -n 127.0.0.1:9876
	 */
	private MQProducerMananger(){
		try {
			defaultProducer = new DefaultMQProducer("rmq-group-producer");
			defaultProducer.setNamesrvAddr("10.192.48.164:9876");
			defaultProducer.setInstanceName("rmq-instance");
			defaultProducer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static class MQProducerManangerHolder{
		private static MQProducerMananger instance=new MQProducerMananger();
	}
	
	public static MQProducerMananger getInstance(){
		return MQProducerManangerHolder.instance;
	}
	
	public SendResult sendMessageToMQ(String message){
		
		try {
			//defaultProducer.start();
			Message msg = new Message("searchLogs", // topic
					"TAG-A", // tag
					message.getBytes()// body
			);			
			return defaultProducer.send(msg);			
		} catch (MQClientException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			defaultProducer.shutdown();
		}
		return null;
	}
}