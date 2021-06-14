package Medium;

/* Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
 *  Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */

public class LC931_MinimumFallingPathSum {

	public static int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[2][col];
        for(int i=0;i<col;i++)
            dp[0][i] = matrix[row-1][i];
        int y[] = {-1,0,1};
        int minSum = 0;
        for(int i=row-2;i>=0;i--){
            for(int j=0;j<col;j++)
                dp[1][j] = dp[0][j];
            for(int j=0;j<col;j++){
                minSum = Integer.MAX_VALUE;
                for(int k=0;k<3;k++){
                    int index = j + y[k];
                    if(index >= 0 && index < matrix[0].length)
                        minSum = Math.min(minSum,dp[1][index]);
                 }
                dp[0][j] = matrix[i][j] + minSum;
            }
        }
        minSum = Integer.MAX_VALUE;
        for(int i=0;i<col;i++)
            minSum = Math.min(minSum,dp[0][i]);
        return minSum;
    }
	
	public static void main(String[] args) {
		int matrix[][] = {{2,1,3},{6,5,4},{7,8,9}};
		System.out.println(minFallingPathSum(matrix));
	}

}
