package Easy;

/*Write a function that reverses a string. The input string is given as an array of characters s.*/

public class LC344_ReverseString {

	public static void reverseString(char[] s) {
        int n = s.length-1;
        char c;
        for(int i=0;i<=n/2;i++){
            c = s[i];
            s[i] = s[n-i];
            s[n-i] = c;
        }
        for(int i=0;i<=n;i++)
        	System.out.print(s[i] + " ");
    }
	
	public static void main(String[] args) {
		char c[] = {'h','e','l','l','o'};
		reverseString(c);
	}

}
