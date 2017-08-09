package com.himalaya.netty;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年8月9日 下午8:11:18
* Description
*/
public class TimeServer {

	public static void main(String[] args) throws IOException {
		
		int port = 8080;
		if(args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
		}
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("Time server is starting at port " + port);
			Socket socket = null;
			while (true) {
				socket = server.accept();
				new Thread(new TimeServerHandler(socket)).start();
			}
		} catch (Exception e) {
			
		} finally {
			
			if (server != null) {
				System.out.println("Time server closed");
				server.close();
				server = null;
			}
		}
	}
}
