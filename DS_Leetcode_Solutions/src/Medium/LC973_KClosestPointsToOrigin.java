package Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/* Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
*/

public class LC973_KClosestPointsToOrigin {

	class Pair {
        int x,y;
        double distance;
        
        Pair(int x,int y){
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt(x*x + y*y);
        }
    }
    
    class MyComparator implements Comparator<Pair> {
        
        @Override
        public int compare(Pair pair1,Pair pair2){
            if(pair2.distance > pair1.distance)
                return 1;
            return -1;
        }
    }
    
    public static int[][] kClosest(int[][] points, int k) {
    	LC973_KClosestPointsToOrigin obj = new LC973_KClosestPointsToOrigin();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(obj.new MyComparator());
        for(int i=0;i<points.length;i++){
            Pair pair = obj.new Pair(points[i][0],points[i][1]);
            if(pq.size() == k && pq.peek().distance > pair.distance)
                pq.poll();
            if(pq.size() < k)
                pq.add(pair);
        }
        int result[][] = new int[k][2];
        for(int i=0;i<k;i++){
            Pair pair = pq.poll();
            result[i][0] = pair.x;
            result[i][1] = pair.y;
        }
        return result;
    }
    
	public static void main(String[] args) {
		int points[][] = {{3,3},{5,-1},{-2,4}};
		System.out.println(kClosest(points,2));
	}

}
