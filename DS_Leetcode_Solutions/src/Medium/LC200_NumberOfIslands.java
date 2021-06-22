package Medium;

/* Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 *  You may assume all four edges of the grid are all surrounded by water.
*/

public class LC200_NumberOfIslands {

	private static int[] x = {-1,0,0,1};
    private static int[] y = {0,-1,1,0};
    
    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
        return count;
    }
    
    private static void dfs(char grid[][],int i,int j){
        grid[i][j] = '0';
        for(int k=0;k<4;k++){
            int a = i + x[k];
            int b = j + y[k];
            if(a >= 0 && a < grid.length && b >= 0 && b < grid[0].length && grid[a][b] == '1')
               dfs(grid,a,b);        
        }
    }
    
	public static void main(String[] args) {
		char grid[][] = {{'1','0','1'},
							 {'1','1','0'}};
		System.out.println(numIslands(grid));
		}
}

