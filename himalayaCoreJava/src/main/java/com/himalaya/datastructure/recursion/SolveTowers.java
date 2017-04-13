package com.himalaya.datastructure.recursion;

public class SolveTowers {

	public void solve(int totalDisk){
		moveTower(totalDisk, 1, 3, 2);
	}
	
	private void moveTower(int totalDisk, int start, int end, int temp){
		
		//System.out.println("start " + start + " end " + end + " temp " + temp);
		if(totalDisk==1){
			moveOneDisk(start, end);
		}else{
			moveTower(totalDisk-1, start, temp, end);
			moveOneDisk(start, end);
			moveTower(totalDisk-1, temp, end, start);
		}
	}
	
	private void moveOneDisk(int start, int end){
		System.out.println("Move disk from " + start + " to " + end);
	}
	
	public static void main(String[] args) {
		SolveTowers solve = new SolveTowers();
		solve.solve(2);
	}
}
