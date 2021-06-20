package Easy;

/* You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string)
 *  that is a non-empty substring of num, or an empty string "" if no odd integer exists.
 *  A substring is a contiguous sequence of characters within a string.
*/

public class LC1903_LargestOddNumberInString {

	public static String largestOddNumber(String num) {
        for(int i=num.length();i>0;i--){
            if(Integer.valueOf(num.charAt(i-1))%2 != 0)
                return num.substring(0,i);
        }
        return "";
    }
	
	public static void main(String[] args) {
		System.out.println(largestOddNumber("4652"));
	}

}
