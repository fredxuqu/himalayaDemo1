package com.himalaya.interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;

public class MessageOutInterceptor extends AbstractPhaseInterceptor<Message>{

	private static final Logger logger = Logger.getLogger(MessageInInterceptor.class);
	
	private final String DEFAULTXPATH = "//return";
	
	private final String SINGLETONMAP_KEY = "ns1";
	
	private final String SINGLETONMAP_VALUE = "http://service.himalaya.com/";

	public MessageOutInterceptor() {
        super(Phase.PRE_STREAM);
    }
	
	public void handleMessage(Message message) throws Fault {
				
		try {
			System.out.println("MessageOutInteceptor.handleMessage() called ");
			
	        System.out.println("getOutMessage------------------"+message.getExchange().getOutMessage());  
	        System.out.println("getOutFaultMessage------------------"+message.getExchange().getOutFaultMessage());  
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
		
	@Override
	public void handleFault(Message message) {
		System.out.println("Output Message Fault Handler.....");		  
        Exception exeption=message.getContent(Exception.class);  
        System.out.println("Exception" + exeption.getMessage()); 
    }
}
