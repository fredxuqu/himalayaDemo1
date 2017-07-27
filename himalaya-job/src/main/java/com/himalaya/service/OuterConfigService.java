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
	
	@Value("${cron.tags}")
	private String tagsCron;

	@Scheduled(cron = "${cron.tags}")
	public void execute() {
		
		logger.info("OuterConfigService, Get cron from yaml, cron : " + tagsCron);
		logger.info("port : " + port + ",sessionTimeout :" + sessionTimeout);
	}
}
