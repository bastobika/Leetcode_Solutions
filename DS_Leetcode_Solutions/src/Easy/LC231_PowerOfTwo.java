package Easy;

/* Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
*/

public class LC231_PowerOfTwo {

	public static boolean isPowerOfTwo(int n) {
        int count = 0;
        while(n > 0){
            count += n&1;
            n = n >> 1;
        }
        return count == 1;
    }
	
	//Trick Solution
	public boolean isPowerOfTwoEfficient(int n) {
        return (n>0&&((n&(n-1))==0));
    }
	
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(16));
	}

}
