package Medium;

/* There is an undirected star graph consisting of n nodes labeled from 1 to n. 
 * A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. 
 * Return the center of the given star graph.
*/

public class LC1791_FindCentreOfStarGraph {

	public static int findCenter(int[][] edges) {
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
            return edges[0][0];
        return edges[0][1];
    }
	
	public static void main(String[] args) {
		int edges[][] = {{1,2},{2,3},{4,2}};
		System.out.println(findCenter(edges));
	}

}
