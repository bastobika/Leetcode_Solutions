package Medium;

/* In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
 * Return the maximum amount of gold you can collect under the conditions:
 * 			1. Every time you are located in a cell you will collect all the gold in that cell.
 * 			2. From your position, you can walk one step to the left, right, up, or down.
 * 			3. You can't visit the same cell more than once.
 * 			4. Never visit a cell with 0 gold.
 * 			5. You can start and stop collecting gold from any position in the grid that has some gold.
 */

public class LC1219_PathWithMaximumGold {

	private static int x[] = {-1,1,0,0};
    private static int y[] = {0,0,-1,1};
    
    public static int getMaximumGold(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                max = Math.max(max,grid[i][j]+findMax(grid,i,j));
        return max;
    }
    
    private static int findMax(int grid[][],int i,int j){
        int temp = grid[i][j];
        grid[i][j] = 0;
        int result = 0;
        for(int k=0;k<4;k++){
            int row = i+x[k];
            int col = j+y[k];
            if(isSafe(grid,row,col))
                result = Math.max(result,grid[row][col]+findMax(grid,row,col));
        }
        grid[i][j] = temp;
        return result;
    }
    
    private static boolean isSafe(int grid[][],int i,int j){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
                && grid[i][j] > 0;
    }
    
	public static void main(String[] args) {
		int arr[][] = {{0,6,0},{5,8,7},{0,9,0}};
		System.out.println(getMaximumGold(arr));
	}

}
