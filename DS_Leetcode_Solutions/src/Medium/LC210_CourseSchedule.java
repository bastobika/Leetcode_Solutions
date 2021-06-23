package Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;

/* There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. 
 * If it is impossible to finish all courses, return an empty array.
*/

public class LC210_CourseSchedule {

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<Integer>());
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        int[] result = new int[numCourses];
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        for(int i=0;i<numCourses;i++)
            if(indegree[i] == 0)
                queue.add(i);
        int j = 0;
        while(!queue.isEmpty()){
            int elem = queue.poll();
            result[j] = elem;
            j++;
            for(int i=0;i<graph.get(elem).size();i++)
                if(--indegree[graph.get(elem).get(i)] == 0)
                    queue.add(graph.get(elem).get(i));
        }
        for(int i=0;i<numCourses;i++)
            if(indegree[i] > 0)
                return new int[0];
        return result;
    }
	
	public static void main(String[] args) {
		int arr[][] = {{1,0},{2,0},{3,1},{3,2}};
		System.out.println(findOrder(4,arr));
	}

}
