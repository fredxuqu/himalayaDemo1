package com.himalaya.zk;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZkClientGetLiveNode {
	
	private final static Logger logger = LoggerFactory.getLogger(ZkClientGetLiveNode.class);
	
	public final static String zkhost = "localhost:2181";
	
	List<String> liveNodesList = new CopyOnWriteArrayList<String>();
	
	public ZkClientGetLiveNode(){
		init();
	}
	
	public List<String> getLiveNodesList() {
		return liveNodesList;
	}

	private void setLiveNodesList(List<String> currentChilds) {
		liveNodesList.clear();
		for (String child : currentChilds) {
			liveNodesList.add(child.replace("_", "/"));
		}
	}

	private void init(){
		ZkClient zkClient = new ZkClient(zkhost, 10000, 10000, new SerializableSerializer());
		
		logger.info("zk client has been initialized!");
		
		zkClient.subscribeChildChanges("/live_nodes", new ZkChildrenListener());
		
		this.setLiveNodesList(zkClient.getChildren("/live_nodes"));
	}

	public class ZkChildrenListener implements IZkChildListener{

		@Override
		public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
			setLiveNodesList(currentChilds);
		}
	}
	
	public static void main(String[] args) {
		ZkClientGetLiveNode zkClient = new ZkClientGetLiveNode();
		List<String> liveNodes = zkClient.getLiveNodesList();
		for (String node : liveNodes) {
			System.out.println(node);
		}
	}
}
