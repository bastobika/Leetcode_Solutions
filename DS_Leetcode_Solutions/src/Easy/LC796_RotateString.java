package Easy;

/* We are given two strings, s and goal.
 * A shift on s consists of taking string s and moving the leftmost character to the rightmost position. 
 * For example, if s = 'abcde', then it will be 'bcdea' after one shift on s. 
 * Return true if and only if s can become goal after some number of shifts on s.
 */

public class LC796_RotateString {

	public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        s += s;
        return s.contains(goal);
    }
	
	public static void main(String[] args) {
		System.out.println(rotateString("abced","cedab"));
	}

}
