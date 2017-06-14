package com.himalaya.network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年6月10日 下午3:14:33
* Description
*/
public class SocketHandler implements Runnable{
	
	Socket socket = null;

	public SocketHandler(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		BufferedInputStream bis = null;
		PrintWriter writer = null;
		
		try {

			bis = new BufferedInputStream(socket.getInputStream());
			
			byte[] bytes = new byte[1024]; 
			
			bis.read(bytes);
			
			System.out.println(new String(bytes,"UTF-8"));
			
			writer = new PrintWriter(socket.getOutputStream());

			writer.write("Hello Fred");
			
			writer.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
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
