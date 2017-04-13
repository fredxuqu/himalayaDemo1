package com.himalaya.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RequestHandler {

	public static void main(String[] args) {
		ServerSocket ss = null;
		
		Runtime.getRuntime().availableProcessors();
		
//		Integer.MAX_VALUE;
		ExecutorService es = Executors.newFixedThreadPool(10);
		try {
			ss = new ServerSocket(80);
			while (true) {
				System.out.println("Waiting for request....");
				final Socket connection = ss.accept();
				System.out.println("Accept a request....");
				
				Runnable task = new Runnable(){
					public void run() {
						try {
							handle(connection);
							System.out.println(Thread.currentThread().getName() + " execute...");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}					
				};
				es.execute(task);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ss != null) {
					ss.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void handle(Socket connection) throws Exception{
		
		InputStream is = connection.getInputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		System.out.println("Get connection from port : " + connection.getPort());
		
		System.out.println(br.readLine());
		
		br.close();
		
		is.close();
	}
}
