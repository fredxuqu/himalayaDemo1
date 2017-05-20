package com.himalaya.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="")
public class DynamicScheduledTask implements SchedulingConfigurer {
	
	private static final Logger logger = LoggerFactory.getLogger(DynamicScheduledTask.class);
	
	@Value("${server.port}")
	private int port;
	
	@Value("${server.sessionTimeout}")
	private int sessionTimeout;

	@Value("${cron.dynamic.social.tags}")
	private String cron;
	
	//from 8 AM to 8 PM, triggered once in every two minutes
	//@Scheduled(cron="0 0/2 8-20 * * ?") 
	//from 8 AM to 8 PM, triggered once in every ten seconds
	//@Scheduled(cron="0/10 * 8-20 * * ?") 
    //@Scheduled(cron="0/10 * * * * ?") 

	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addTriggerTask(new Runnable(){

			public void run() {
				Thread current = Thread.currentThread();
		        logger.info("dynamic scheduler executed, " + current.getId());
			}			
		}, new Trigger(){

			public Date nextExecutionTime(TriggerContext triggerContext) {
				CronTrigger trigger = new CronTrigger(cron);
			    Date nextExecDate = trigger.nextExecutionTime(triggerContext);
			    return nextExecDate;
			}
		});
	}
}
