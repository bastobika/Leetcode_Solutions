package Medium;

/* A conveyor belt has packages that must be shipped from one port to another within days days.
 * The ith package on the conveyor belt has a weight of weights[i]. 
 * Each day, we load the ship with packages on the conveyor belt (in the order given by weights). 
 * We may not load more weight than the maximum weight capacity of the ship.
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
*/

public class LC1011_CapacityToShipPackagesWithinDDays {

	public static int shipWithinDays(int[] weights, int days) {
        int high = 0;
        int low = weights[0];
        for(int i=0;i<weights.length;i++)
            high += weights[i];
        int mid = 0;
        while(low < high){
            mid = (low+high)/2;
            if(countDays(mid,weights) <= days)
                high = mid;
            else
                low = mid+1;
        }
        return high;
    }
    
    private static int countDays(int mid,int weights[]){
        int count = 0;
        int sum = 0;
        for(int i=0;i<weights.length;i++){
            if(weights[i] > mid)
                return Integer.MAX_VALUE;
            if(sum + weights[i] > mid){
                count++;
                sum = 0;
            }
            sum += weights[i];
        }
        if(sum <= mid)
            count++;
        return count;
    }
    
	public static void main(String[] args) {
		int weights[] = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(shipWithinDays(weights,5));
	}

}
