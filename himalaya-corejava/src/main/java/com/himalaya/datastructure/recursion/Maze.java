package com.himalaya.datastructure.recursion;

public class Maze {
	
	private final int TRIED = 3;
	private final int PATH = 7;
	private int[][] grid = {{1,0,1,1,1,1,1,1,1,0,0,1},
							{1,0,1,0,1,0,0,0,0,0,0,0},
							{1,1,1,0,1,1,1,1,1,1,1,1},
							{1,0,0,0,0,1,0,0,0,0,0,0},
							{1,0,1,1,0,1,1,1,1,0,1,1},
							{0,1,1,1,0,0,0,1,0,0,0,0},
							{1,1,1,1,0,1,0,1,1,1,1,0},
							{1,1,1,1,1,1,0,1,0,0,1,1}};
	
	public boolean traverse(int row, int column){
		boolean done = false;
		if(valid(row,column)){
			
			grid[row][column] = TRIED;
			
			if(row==grid.length-1 && column==grid[row].length-1){
				done = true;
			}else{
				done = traverse(row+1, column);
				if(!done){
					done = traverse(row, column + 1);
				}
				if(!done){
					done = traverse(row-1, column);
				}
				if(!done){
					done = traverse(row, column-1);
				}
			}
			
			if(done){
				grid[row][column] = PATH;
			}
		}
		return done;
	}
	
	private boolean valid(int row, int column){
		boolean isValid = false;
		if(row >= 0 && row < grid.length 
			&& column >=0 && column<grid[row].length){
			if(grid[row][column]==1){
				return true;
			}
		}
		return isValid;
	}
	
	public String toString(){ 
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				sb.append(grid[i][j]);
			}
			sb.append("\r\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		
		Maze maze = new Maze();
		System.out.println(maze);
		
		maze.traverse(0, 0);
		
		System.out.println(maze);
	}
}
