package Medium;

/*
 * There is a restaurant with a single chef. You are given an array customers, where customers[i] = [arrivali, timei]:
 * 		1. arrivali is the arrival time of the ith customer. The arrival times are sorted in non-decreasing order.
 * 		2. timei is the time needed to prepare the order of the ith customer.
 * When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle. 
 * The customer waits till the chef finishes preparing his order. The chef does not prepare food for more than one customer at a time. 
 * The chef prepares food for customers in the order they were given in the input.
 * Return the average waiting time of all customers. Solutions within 10-5 from the actual answer are considered accepted.
*/

public class LC1701_AverageWaitingTime {

	public static double averageWaitingTime(int[][] customers) {
        double sum = 0;
        int currentEnd = 0;
        for(int i=0;i<customers.length;i++){
            if(currentEnd > customers[i][0]){
                sum += currentEnd - customers[i][0] + customers[i][1];
                currentEnd += customers[i][1];
            }else{
                sum += customers[i][1];
                currentEnd = customers[i][0] + customers[i][1];
            }
        }
        return (double)(sum/customers.length);
    }
	
	public static void main(String[] args) {
		int customers[][] = {{1,2},{2,5},{4,3}};
		System.out.println(averageWaitingTime(customers));
	}

}
