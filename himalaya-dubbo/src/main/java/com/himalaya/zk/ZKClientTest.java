package com.himalaya.zk;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZKClientTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ZKClientTest.class);
	
	private final static String HOST="localhost";
	
	private static void create(ZooKeeper zk, String path, String data, CreateMode mode){
		try {
			Stat stat = isNodeExist(zk, path);
			if(stat!=null){
				System.out.println("Node " + path + " is exist");
			}else{
				zk.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, mode);				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Stat isNodeExist(ZooKeeper zk, String path) throws Exception{
		return zk.exists(path, true);
	}
	
	private static void exists(ZooKeeper zk, String path){
		try {
			Stat stat = isNodeExist(zk, path);
			if(stat!=null){
				System.out.println(path + " version is " + stat.getVersion());
			}else{
				System.out.println("Node " + path + " is not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getData(final ZooKeeper zk, final String path){
		String data = null;
		try {
			final CountDownLatch connectionSignal = new CountDownLatch(1);
			Stat stat = isNodeExist(zk, path);
			if(stat!=null){
				byte[] bytes = zk.getData(path, new Watcher(){

					public void process(WatchedEvent event) {
						if(event.getType()==Event.EventType.None){
							switch (event.getState()) {
								case Expired:
									connectionSignal.countDown();
									break;
							}
						}else{
							try {
								byte[] bytes = zk.getData(path, true, null);
								logger.info(new String(bytes, "UTF-8"));
								connectionSignal.countDown();
							} catch (Exception e) {
								e.printStackTrace();
							} finally{
								connectionSignal.countDown();
							}							
						}
					}					
				}, null);
				data = new String(bytes, "UTF-8");
				connectionSignal.countDown();
				connectionSignal.await();
			}else{
				System.out.println("Node is not exist!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
		}
		return data;
	}
	
	private static void setData(ZooKeeper zk, String path, String data){
		try {
			Stat stat = isNodeExist(zk, path);
			if(stat!=null){
				zk.setData(path, data.getBytes(), stat.getVersion());
			}else{
				System.out.println("Node " + path + " is not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void getChildren(ZooKeeper zk, String path){
		logger.info("getChildren");
		try {
			Stat stat = isNodeExist(zk, path);
			if(stat!=null){
				List<String> list = zk.getChildren(path, true, null);
				for (String c : list) {
					logger.info("[" + c +"] ");
				}
			}else{
				System.out.println("Parent Node " + path + " is not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void delete(ZooKeeper zk, String path){
		try {
			Stat stat = isNodeExist(zk, path);
			if(stat!=null){
				List<String> list = zk.getChildren(path, true, null);
				if(list !=null && list.size()>0){
					System.out.println("Path " + path + " has children, can't be delete!");
					return ;
				}
				zk.delete(path, stat.getVersion());
			}else{
				System.out.println("Parent Node " + path + " is not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ZKConnection connection = null;
				
		try {
			connection = new ZKConnection();
			ZooKeeper zk = connection.connect(HOST);
			
			create(zk, "/Ephemeral", "Ephemeral Apple", CreateMode.EPHEMERAL);
			
			create(zk, "/fruit", "Persistent Fruit", CreateMode.PERSISTENT);
			
			create(zk, "/fruit/apple", "Persistent Fruit/Apple", CreateMode.PERSISTENT);
		
			// get node data
			String data = getData(zk, "/Ephemeral");
			System.out.println(data);
			
			// set data
			String dataJson = "{id=1,name=fred}";
			setData(zk, "/Ephemeral", dataJson);
			
			// get node data
			data = getData(zk, "/Ephemeral");
			System.out.println(data);
			
			Stat stat = isNodeExist(zk, "/fruit/apple");
			System.out.println("Node /fruit/apple version " + stat.getVersion());
			
			// get children 
			getChildren(zk, "/fruit");
			System.out.println();
			
			// delete node
			delete(zk, "/fruit3/apple");
			delete(zk, "/fruit3");
			
			logger.info("Main......");
			
			// get children 
//			getChildren(zk, "/configs/tagsdih");
						
//			String data = getData(zk, "/configs/tagsdih/dataimport.properties");
//			logger.info("-------------------- " + data);
			
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			connection.close();
		}
	}
}
