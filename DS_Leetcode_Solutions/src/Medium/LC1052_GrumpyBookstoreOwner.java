package Medium;

/*Today, the bookstore owner has a store open for customers.length minutes. 
 *  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
 *  On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0. 
 *   When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
 *   The bookstore owner knows a secret technique to keep themselves not grumpy for minutes minutes straight, but can only use it once.
 *   Return the maximum number of customers that can be satisfied throughout the day.
*/

public class LC1052_GrumpyBookstoreOwner {

	public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int happyCustomers = 0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i] == 0){
                happyCustomers += customers[i];
                customers[i] = 0;
            }
        }
        int sum = 0;
        for(int i=0;i<minutes;i++)
            sum += customers[i];
        int max = sum;
        for(int i=minutes;i<customers.length;i++){
            sum = sum-customers[i-minutes]+customers[i];
            max = Math.max(max,sum);
        }
        return happyCustomers + max;
    }
	
	public static void main(String[] args) {
		int customers[] = {1,0,1,2,1,1,7,5};
		int grumpy[] = {0,1,0,1,0,1,0,1};
		System.out.println(maxSatisfied(customers,grumpy,3));
	}

}
