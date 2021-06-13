package Easy;

/* You have a long flower bed in which some of the plots are planted, and some are not. 
 * 	However, flowers cannot be planted in adjacent plots.
 * Given an integer array flower bed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, 
 * return if n new flowers can be planted in the flower bed without violating the no-adjacent-flowers rule.
*/

public class LC605_CanPlaceFlowers {

	//Time Complexity - O(n * LengthOfFlowerBed) 
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int i = 0;
	    while(n > 0){
	        for(i=0;i<flowerbed.length;i++){
	            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] != 1) 
	                             && (i == flowerbed.length-1 || flowerbed[i+1] != 1)){
	                flowerbed[i] = 1;
	                n--;
	                break;
	            }
	        }
	        if(i == flowerbed.length)
	            return false;
	    }
	    return true; 
	}
	
	//Time Complexity - O(LengthOfFlowerBed)
	public static boolean canPlaceFlowersEfficient(int[] flowerbed, int n) {
		int possible = 0; 
	       for(int i=0;i<flowerbed.length;i++){
	            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] != 1) 
	                             && (i == flowerbed.length-1 || flowerbed[i+1] != 1)){
	                possible++;
	                i++;
	            }
	        } 
	        return possible >= n;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,0,0,0,1};
		System.out.println(canPlaceFlowersEfficient(arr,1));
	}

}
