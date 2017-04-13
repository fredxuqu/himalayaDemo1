package com.himalaya.concurrency;

import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadWebServer {
	
	public void handleRequest() throws Exception{
		
		ServerSocket ss = new ServerSocket(80);
		while(true){
			Socket connection = ss.accept();
			handle(connection);
		}
	}
	
	private void handle(Socket connection){
		System.out.println(connection.getPort());
	}
}
