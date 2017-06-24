package com.himalaya.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2017年6月20日 下午1:09:31 Description
 */
public class ServerCompletionHandler implements CompletionHandler<AsynchronousServerSocketChannel, Server> {

	private void read(final AsynchronousSocketChannel asc) {
		// 读取数据
		ByteBuffer buf = ByteBuffer.allocate(1024);
		asc.read(buf, buf, new CompletionHandler<Integer, ByteBuffer>() {
			@Override
			public void completed(Integer resultSize, ByteBuffer attachment) {
				// 进行读取之后,重置标识位
				attachment.flip();
				// 获得读取的字节数
				System.out.println("Server -> " + "收到客户端的数据长度为:" + resultSize);
				// 获取读取的数据
				String resultData = new String(attachment.array()).trim();
				System.out.println("Server -> " + "收到客户端的数据信息为:" + resultData);
				String response = "服务器响应, 收到了客户端发来的数据: " + resultData;
				write(asc, response);
			}

			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				exc.printStackTrace();
			}
		});
	}

	private void write(AsynchronousSocketChannel asc, String response) {
		try {
			ByteBuffer buf = ByteBuffer.allocate(1024);
			buf.put(response.getBytes());
			buf.flip();
			asc.write(buf).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void failed(Throwable exc, Server attachment) {
		exc.printStackTrace();
	}

	@Override
	public void completed(AsynchronousServerSocketChannel result, Server attachment) {
		attachment.assc.accept(attachment, this);
		read(result);
	}
}
