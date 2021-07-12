package Easy;

/* Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 
 * 90-degree increments, or false otherwise. 
 */

public class LC1886_DetermineIfMatrixCanBeObtainedByRotation {

	public static boolean findRotation(int[][] mat, int[][] target) {
        for(int k=0;k<4;k++){
            //transpose of mat
            for(int i=0;i<mat.length;i++){
                for(int j=i+1;j<mat.length;j++){
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
            //column swap of mat to get 90 degree rotation
            for(int i=0;i<mat.length/2;i++){
                for(int j=0;j<mat.length;j++){                
                    int temp = mat[j][i];
                    mat[j][i] = mat[j][mat.length-i-1];
                    mat[j][mat.length-i-1] = temp;
                }
            }
            boolean flag = true;
            //check equality
            for(int i=0;i<mat.length;i++)
                for(int j=0;j<mat.length;j++)
                    if(mat[i][j] != target[i][j]){
                        flag = false;
                        break;
                    }
            if(flag)
                return flag;
        }
        return false;
    }
	
	public static void main(String[] args) {
		int mat[][] = {{0,1},{1,1}};
		int target[][] = {{1,0},{0,1}};
		System.out.println(findRotation(mat,target));
	}

}
