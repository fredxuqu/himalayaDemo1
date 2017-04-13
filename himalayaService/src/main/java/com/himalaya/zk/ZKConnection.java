package com.himalaya.zk;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class ZKConnection {
	
	private final static int SESSION_TIMEOUT = 5000;
	
	private static CountDownLatch connectedSignal = new CountDownLatch(1);
	
	private static ZooKeeper zk = null;
	
	public ZooKeeper connect(String host)throws InterruptedException, IOException{
		
		zk = new ZooKeeper(host, SESSION_TIMEOUT, new Watcher(){

			public void process(WatchedEvent event) {
				if(event.getState() == KeeperState.SyncConnected){
					connectedSignal.countDown();
				}
			}			
		});
		connectedSignal.await();
		return zk;
	}
	
	public void close(){
		try {
			zk.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
