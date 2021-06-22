package Easy;

/* Given a pattern and a string s, find if s follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
*/

public class LC290_WordPattern {

	public static boolean wordPattern(String pattern, String s) {
        String array[] = new String[26];
        String words[] = s.split(" ");
        int j = 0;
        for(int i=0;i<words.length;i++){
            if(j >= pattern.length() || isFalse(words[i],array,pattern.charAt(j)-'a'))
                return false;
            array[pattern.charAt(j)-'a'] = words[i];
            j++;
        }
        return j == pattern.length();
    }
    
    private static boolean isFalse(String temp,String array[],int j){
        if(array[j] != null && !temp.equals(array[j]))
            return true;
        for(int i=0;i<26;i++)
            if(temp.equals(array[i])){
                if(i == j)
                    return false;
                return true;
            }
        return false;
    }
    
	public static void main(String[] args) {
		String pattern = "abba";
		String s = "dog cat cat dog";
		System.out.println(wordPattern(pattern,s));
	}

}
