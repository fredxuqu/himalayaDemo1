package com.himalaya.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;

@Service
public class LogMessageListener implements MessageListenerConcurrently{
	
	@Override
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		for (MessageExt msg : msgs) {
			System.out.println(Thread.currentThread().getName() + " -- " + new String(msg.getBody()));
		}
		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}
}
