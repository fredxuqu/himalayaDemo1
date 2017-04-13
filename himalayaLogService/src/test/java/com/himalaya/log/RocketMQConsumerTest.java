package com.himalaya.log;

import java.util.List;

import org.junit.Test;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;

public class RocketMQConsumerTest {
	
	@Test
	public void test(){
		try {
			DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("rmq-group");
			consumer.setNamesrvAddr("10.192.48.164:9876");
			consumer.setInstanceName("rmq-instance");					
			consumer.subscribe("TopicA-test", "TagA");

			consumer.registerMessageListener(new MessageListenerConcurrently() {
				@Override
				public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
					for (MessageExt msg : msgs) {
						System.out.println(new String(msg.getBody()));
					}
					return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				}
			});
			consumer.start();
			System.out.println("Consumer Started.");
		} catch (MQClientException e) {
			e.printStackTrace();
		}
	}
}
