package com.himalaya.log;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class RMQProducerTest {

	@Autowired
	// @Qualifier("defaultConsumer")
	private DefaultMQProducer defaultProducer;

	@Value("#{propertiesReader[topic1]}")
	private String topic1;

	@Value("#{propertiesReader[tag1]}")
	private String tag1;

	//@Before
	public void setUp() throws Exception {
		System.out.println("-----------");
	}

	@After
	public void tearDown() throws Exception {
		// defaultConsumer.shutdown();
	}

	@Test
	public void testDefault() throws MQClientException, InterruptedException {

		try {
			for (int i = 0; i < 3; i++) {
				Message msg = new Message(topic1, // topic
						tag1, // tag
						(new Date() + "Send by Spring , Hello RocketMQ , QuickStart" + i).getBytes()// body
				);
				//SendResult sendResult = defaultProducer.send(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	public void test() {

		try {
			DefaultMQProducer defaultProducer = new DefaultMQProducer("rmq-group");
			defaultProducer.setNamesrvAddr("10.192.48.164:9876");
			defaultProducer.setInstanceName("rmq-instance");
			defaultProducer.start();

			for (int i = 0; i < 3; i++) {
				Message msg = new Message(topic1, // topic
						tag1, // tag
						(new Date() + "Send by Spring , Hello RocketMQ , QuickStart" + i).getBytes()// body
				);
				SendResult sendResult = defaultProducer.send(msg);
			}

			for (int i = 3; i <= 6; i++) {
				Message msg = new Message(topic1, // topic
						tag1, // tag
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
	}*/
}
