package Medium;

/* You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
 * You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
*/

public class LC695_MaxAreaOfIsland {

	private static int x[] = {-1,0,0,1};
    private static int y[] = {0,-1,1,0};
    
    public static int maxAreaOfIsland(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(!visited[i][j] && grid[i][j] == 1)
                    maxArea = Math.max(maxArea,dfs(grid,i,j,visited));
        return maxArea;
    }
    
    private static int dfs(int grid[][],int i,int j,boolean visited[][]){
        visited[i][j] = true;
        int area = 1;
        for(int k=0;k<4;k++)
            if(isSafe(grid,i+x[k],j+y[k],visited))
                area += dfs(grid,i+x[k],j+y[k],visited);
        return area;
    }
    
    private static boolean isSafe(int grid[][],int i,int j,boolean visited[][]){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1
                && !visited[i][j];
    }
    
	public static void main(String[] args) {
		int grid[][] = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
							 {0,0,0,0,0,0,0,1,1,1,0,0,0},
							 {0,1,1,0,1,0,0,0,0,0,0,0,0},
							 {0,1,0,0,1,1,0,0,1,0,1,0,0},
							 {0,1,0,0,1,1,0,0,1,1,1,0,0},
							 {0,0,0,0,0,0,0,0,0,0,1,0,0},
							 {0,0,0,0,0,0,0,1,1,1,0,0,0},
							 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		System.out.println(maxAreaOfIsland(grid));
	}
}

