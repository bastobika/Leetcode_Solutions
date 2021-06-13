package Easy;

/*Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. */

public class LC125_ValidPalindrome {
	
	//Takes more than one loop
	public static boolean isPalindrome(String s) {
        String str = "";        
        s = s.toLowerCase();
        char c;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i); 
            if((c-'a' >= 0 && c-'a' <= 25) || (c-'0' >= 0 && c-'0' <= 9))
                str += c;
        }
        int n = str.length();
        for(int i=0;i<n;i++){
            if(str.charAt(i) != str.charAt(n-i-1))
                return false;
        }
        return true;
    }
	
	//Takes one loop
	public static boolean isPalindromeEfficient(String s) {
        int n = s.length()-1;
        int i = 0;
        while(i < n){
            while(i < n && !(s.charAt(i)-'a' >= 0 && s.charAt(i)-'a' <= 25) 
                    && !(s.charAt(i)-'A' >= 0 && s.charAt(i)-'A' <= 25)
                    && !(s.charAt(i)-'0' >= 0 && s.charAt(i)-'0' <= 9))
                i++;
            while(i < n && !(s.charAt(n)-'a' >= 0 && s.charAt(n)-'a' <= 25) 
                    && !(s.charAt(n)-'A' >= 0 && s.charAt(n)-'A' <= 25)
                    && !(s.charAt(n)-'0' >= 0 && s.charAt(n)-'0' <= 9))
                n--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(n)))
                return false;
            i++;
            n--;
        }
        return true;
    }
	
	public static void main(String[] args) {
		String s = "A man,a car : Panama";
		System.out.println(isPalindromeEfficient(s));
	}
}
