package com.himalaya.network;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年6月10日 下午3:09:20
* Description
*/
public class SocketServer {
	
	private static final int PORT = 8765;
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		try {
			serverSocket = new ServerSocket(PORT);
			
			System.out.println("waiting for connection....");
			
			Socket socket = serverSocket.accept();
			
			threadPool.execute(new SocketHandler(socket));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
