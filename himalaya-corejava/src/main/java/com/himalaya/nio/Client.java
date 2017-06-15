package com.himalaya.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

	public static void main(String[] args) {
		
		InetSocketAddress remote = new InetSocketAddress("127.0.0.1",8765);
		
		SocketChannel sc = null;
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		try {
			sc = SocketChannel.open();
			sc.connect(remote);
			while(true){
				byte[] bytes = new byte[1024];
				System.out.print("Please Input : ");
				System.in.read(bytes);
				buffer.put(bytes);
				buffer.flip();
				sc.write(buffer);
				buffer.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(sc!=null){
				try {
					sc.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
