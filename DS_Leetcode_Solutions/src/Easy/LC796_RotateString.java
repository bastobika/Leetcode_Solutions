package Easy;

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
