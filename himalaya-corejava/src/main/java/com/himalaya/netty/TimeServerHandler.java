package com.himalaya.netty;

import java.net.Socket;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年8月9日 下午8:18:15
* Description
*/
public class TimeServerHandler implements Runnable{
	private Socket socket;
	
	public TimeServerHandler(Socket socket){
		this.socket = socket;
	}

	@Override
	public void run() {
		
	}
}
