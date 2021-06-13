package Easy;

/*	Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * Note that in some languages, such as Java, there is no unsigned integer type. 
 * In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, 
 * whether it is signed or unsigned.
 */

public class LC191_NumberOfOneBits {

	public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
	
	public static void main(String[] args) {
		System.out.println(hammingWeight(946));
	}

}
