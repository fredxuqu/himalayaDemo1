package com.himalaya.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年6月10日 下午3:30:50
* Description
*/
public class SocketClient {
	
	private final static String HOST = "127.0.0.1";
	private final static int PORT = 8765;
	
	public static void main(String[] args) {
		
		Socket socket = null;
		PrintWriter writer = null;
		BufferedReader reader = null;
		try {
			socket = new Socket(HOST, PORT);
			
			writer = new PrintWriter(socket.getOutputStream());
			
			writer.write("userName: admin, password: admin");
			
			writer.flush();
			
			socket.shutdownOutput();
			
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String message = null;
			
			while((message=reader.readLine())!=null){
				System.out.println("Client, server said : " + message);
			}		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			writer.close();
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
