package Medium;

/* There are n cities. Some of them are connected, while some are not. 
 * If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
*/

public class LC547_NumberOfProvinces {

	public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int result = 0;
        for(int i=0;i<n;i++)
            if(!visited[i]){
                result++;
                dfs(isConnected,visited,i);
            }
        return result;
    }
    
    private static void dfs(int[][] isConnected,boolean visited[],int source){
        visited[source] = true;
        for(int i=0;i<isConnected.length;i++)
            if(isConnected[source][i] == 1 && !visited[i])
                dfs(isConnected,visited,i);
    }
    
	public static void main(String[] args) {
		int arr[][] = {{1,0,0},{0,1,0},{0,0,1}};
		System.out.println(findCircleNum(arr));
	}

}
