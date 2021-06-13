package Easy;

/* You have n coins and you want to build a staircase with these coins. 
 * The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
 * Given the integer n, return the number of complete rows of the staircase you will build.
 */
 
public class LC441_ArrangeCoins {

	public static int arrangeCoins(int n) {
        int rows = 0;
        int i = 1;
        while(n > 0){
            if(n >= i)
                rows++;
            n -= i++;
            i++;
        }
        return rows;
    }
	
	public static void main(String[] args) {
		System.out.println(arrangeCoins(5));
	}

}
