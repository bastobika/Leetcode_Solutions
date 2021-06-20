package Medium;

import java.util.ArrayDeque;

/* You are given an m x n grid where each cell can have one of three values:
 * 		1. 0 representing an empty cell.
 * 		2. 1 representing a fresh orange.
 * 		3. 2 representing a rotten orange.
* Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
* Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
*/

public class LC994_RottingOranges {

	class Pair{
        int x,y;
        
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static int orangesRotting(int[][] grid) {
        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        int good = 0;
        LC994_RottingOranges obj = new LC994_RottingOranges();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2)
                    queue.add(obj.new Pair(i,j));
                if(grid[i][j] == 1)
                    good++;
            }
        }
        int time = 0;
        int rotten = 0;
        int x[] = {-1,0,0,1};
        int y[] = {0,-1,1,0};
        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            for(int k=0;k<size;k++){
                Pair pair = queue.poll();
                for(int i=0;i<4;i++){
                    int a = pair.x + x[i];
                    int b = pair.y + y[i];
                    if(isSafe(a,b,grid)){
                        grid[a][b] = 2;                            
                        queue.add(obj.new Pair(a,b));
                        rotten++;
                    }           
                }
            }
        }
        return good == 0 ? 0 : rotten == good ? time-1 : -1; 
    }
    
    private static boolean isSafe(int i,int j,int[][] grid){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1;
    }
    
	public static void main(String[] args) {
		int grid[][] = {{2,1,1},{0,1,0},{0,1,1}};
		System.out.println(orangesRotting(grid));
	}

}
