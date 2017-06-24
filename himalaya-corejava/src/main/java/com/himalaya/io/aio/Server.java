package com.himalaya.io.aio;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年6月20日 下午1:00:23
* Description
*/
public class Server {

	ExecutorService executorService = null;
	AsynchronousChannelGroup threadGroup = null;
	public AsynchronousServerSocketChannel assc = null;
	public Server(int port){
		try {
			executorService = Executors.newCachedThreadPool();
			
			threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
		
			assc = 	AsynchronousServerSocketChannel.open(threadGroup);	
			
			assc.bind(new InetSocketAddress(port));
			
			System.out.println("Server start, port : " + port);
			
			assc.accept(this, new ServerCompletionHandler());
			
			Thread.sleep(Integer.MAX_VALUE);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server(8765);
	}
}
