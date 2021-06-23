package Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;

/* There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 *  You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *  For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 *  Return true if you can finish all courses. Otherwise, return false.
*/

public class LC207_CourseSchedule {

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<Integer>());
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        for(int i=0;i<numCourses;i++)
            if(indegree[i] == 0)
                queue.add(i);
        while(!queue.isEmpty()){
            int elem = queue.poll();
            for(int i=0;i<graph.get(elem).size();i++)
                if(--indegree[graph.get(elem).get(i)] == 0)
                    queue.add(graph.get(elem).get(i));
        }
        for(int i=0;i<numCourses;i++)
            if(indegree[i] > 0)
                return false;
        return true;
    }
	
	public static void main(String[] args) {
		int arr[][] = {{1,0},{2,3},{2,0},{3,4},{4,0}};
		System.out.println(canFinish(5,arr));
	}

}
