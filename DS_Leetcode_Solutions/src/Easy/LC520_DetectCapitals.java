package Easy;

/* We define the usage of capitals in a word to be right when one of the following cases holds:
 * 		1. All letters in this word are capitals, like "USA".
 * 		2. All letters in this word are not capitals, like "leetcode".
 * 		3. Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
*/

public class LC520_DetectCapitals {

	public static boolean detectCapitalUse(String word) {
        int capitals = 0;
        int smalls = 0;
        for(int i=1;i<word.length();i++)
            if(word.charAt(i) < 97)
                capitals++;
            else
                smalls++;
        if(word.charAt(0) < 97)
            return capitals == word.length()-1 || smalls == word.length() - 1;
        return capitals == 0;
    }
	
	public static void main(String[] args) {
		System.out.println(detectCapitalUse("FlaG"));
	}

}
