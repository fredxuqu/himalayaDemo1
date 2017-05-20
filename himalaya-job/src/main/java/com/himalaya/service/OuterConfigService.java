package com.himalaya.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OuterConfigService {

	private static final Logger logger = LoggerFactory.getLogger(OuterConfigService.class);
	
	@Value("${server.port}")
	private int port;
	
	@Value("${server.sessionTimeout}")
	private int sessionTimeout;

	@Scheduled(cron = "${cron.tags}")
	public void execute() {

		logger.info("port : " + port + ",sessionTimeout :" + sessionTimeout);
		// Thread current = Thread.currentThread();
		// System.out.println("schedule1:"+current.getId());
		logger.info("OuterConfigService.execute()");
	}
}
