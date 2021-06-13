package Easy;

import java.util.ArrayDeque;

/* An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
 * plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. 
 * Replace the color of all of the aforementioned pixels with newColor.Return the modified image after performing the flood fill.
 */

public class LC733_FloodFill {

	class Pair {
        int i;
        int j;
        
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean visited[][] = new boolean[image.length][image[0].length];
        int oldColor = image[sr][sc];
        int x[] = {-1,1,0,0};
        int y[] = {0,0,-1,1};
        int a = 0;
        int b = 0;
        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();        
        image[sr][sc] = newColor;
        LC733_FloodFill obj = new LC733_FloodFill();
        queue.add(obj.new Pair(sr,sc));
        while(!queue.isEmpty()){
            Pair element = queue.poll();
            visited[element.i][element.j] = true;
            for(int i=0;i<4;i++){
                a = element.i+x[i];
                b = element.j+y[i];
                if(isSafe(a,b,visited,image,oldColor)){
                    image[a][b] = newColor;
                    queue.add(obj.new Pair(a,b));
                }
            }
        }
        return image;
    }
    
    private static boolean isSafe(int i,int j,boolean[][] visited,int[][] image,int oldColor){
        return i >= 0 && i < image.length && j >= 0 && j <image[0].length 
                    && image[i][j] == oldColor && !visited[i][j];
    }
    
	public static void main(String[] args) {
		int image[][] = {{1,1,1},{1,1,0},{1,0,1}};
		System.out.println(floodFill(image,1,1,2));
	}

}
