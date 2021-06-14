package Easy;

/*Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
*/

public class LC66_PlusOne {

	public static int[] plusOne(int[] digits) {
        int add = 1;
        for(int i=digits.length-1;i>=0;i--){          
            int carry = digits[i] + add > 9 ? 1 : 0;
            digits[i] = (digits[i] + add)%10 ;
            if(carry == 0)
                return digits;     //Early return - Improving TC for best case scenario
            add = carry;
        }
        if(digits[0] == 0){
            int result[] = new int[digits.length+1];
            result[0] = 1;
     /*     for(int i=0;i<digits.length;i++)
                result[i+1] = digits[i]; */        //No need to copy because all are zeros
            return result;
        }
        return digits;
    }
	
	public static void main(String[] args) {
		int digits[] = {9,9,9};
		System.out.println(plusOne(digits));
	}

}
