package com.himalaya.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2017年6月14日 下午8:22:32 Description
 */
public class ServerSocketChannelDemo {

	public static void main(String[] args) {
		Thread thread = new Thread(new Server(8765));
		thread.start();
	}
}

class Server implements Runnable{

	private Selector selector;
	
	private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
	
	public Server(int port){
		
		try {
			// 打开多路复用器
			this.selector = Selector.open();
			
			// 打开服务器通道
			ServerSocketChannel channel = ServerSocketChannel.open();
			
			// 设置通道为阻塞模式
			channel.configureBlocking(false);
			
			// 绑定端口
			channel.bind(new InetSocketAddress(port));
			
			// 注册服务器通道到多路复用器上面，并且监听阻塞事件
			channel.register(this.selector, SelectionKey.OP_ACCEPT);
			
			System.out.println("Server is running......");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				this.selector.select();
				Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
				while(keys.hasNext()){
					
					SelectionKey key = keys.next();
					keys.remove();
					if(key.isValid()){
						if(key.isAcceptable()){
							this.accept(key);
						}
						
						if(key.isReadable()){
							this.read(key);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void accept(SelectionKey key){
		try {
			ServerSocketChannel channel = (ServerSocketChannel) key.channel();
			SocketChannel socketChannel = channel.accept();
			socketChannel.configureBlocking(false);
			socketChannel.register(this.selector, SelectionKey.OP_READ);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void read(SelectionKey key){
		try {
			this.readBuffer.clear();
			SocketChannel socketChannel = (SocketChannel) key.channel();
			int count = socketChannel.read(this.readBuffer);
			if(count==-1){
				key.channel().close();
				key.channel();
				return;
			}
			this.readBuffer.flip();
			byte[] bytes = new byte[this.readBuffer.remaining()];
			this.readBuffer.get(bytes);
			String body = new String(bytes);
			System.out.println("Server:" + body);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
