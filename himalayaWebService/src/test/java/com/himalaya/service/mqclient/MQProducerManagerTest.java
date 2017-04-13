package com.himalaya.service.mqclient;

import java.util.Date;

import org.junit.Test;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

public class MQProducerManagerTest {
	
	MQProducerMananger manager = null;
	
	@Test
	public void testGetInstance(){
		
		MQProducerMananger manager = MQProducerMananger.getInstance();
	}
	
	@Test
	public void testSendMessageToMQ(){
		manager = MQProducerMananger.getInstance();
		manager.sendMessageToMQ("dsfasdfadf"); 
	}
	
	@Test
	public void testMQProducer(){
		try {
			DefaultMQProducer defaultProducer = new DefaultMQProducer("rmq-group");
			defaultProducer.setNamesrvAddr("10.192.48.164:9876");
			defaultProducer.setInstanceName("rmq-instance");
			defaultProducer.start();

			for (int i = 0; i < 3; i++) {
				Message msg = new Message("searchLogs", // topic
						"TAG-A", // tag
						(new Date() + "Send by Spring , Hello RocketMQ , QuickStart" + i).getBytes()// body
				);
				SendResult sendResult = defaultProducer.send(msg);
			}

			for (int i = 3; i <= 6; i++) {
				Message msg = new Message("searchLogs", // topic
						"TAG-A", // tag
						(new Date() + "Send by Spring , Hello RocketMQ , QuickStart" + i).getBytes()// body
				);
				SendResult sendResult = defaultProducer.send(msg);
			}

			defaultProducer.shutdown();
		} catch (MQClientException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}