package Medium;

import java.util.ArrayList;
import java.util.List;

/* Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
*/

public class LC797_AllPathsFromSourceToTarget {

	List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.result = new ArrayList<List<Integer>>(); 
        dfs(graph,0,graph.length-1,new ArrayList<Integer>());
        return this.result;
    }
    
    private void dfs(int[][] graph,int src,int dest,ArrayList<Integer> curr){
        curr.add(src);
        if(src == dest){
            this.result.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i=0;i<graph[src].length;i++){
            dfs(graph,graph[src][i],dest,curr);
            curr.remove(curr.size()-1);
        }
    }
    
	public static void main(String[] args) {
		System.out.println("All paths from source to destination");
	}

}
