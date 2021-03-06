package Easy;

import java.util.ArrayDeque;

/* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if: 
 * 			1. Open brackets must be closed by the same type of brackets.
 * 			2. Open brackets must be closed in the correct order.
 */

public class LC20_ValidParenthesis {

	public static boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ')' || c == '}' || c == ']'){
                if(!stack.isEmpty() && matches(c,stack.peek()))
                    stack.pop();
                else
                    return false;
            }else
                stack.push(c);
        }
        return stack.isEmpty();
    }
    
    private static boolean matches(char c,char x){
        if((c == ')' && x == '(') || (c == '}' && x == '{') || (c == ']' && x == '['))
            return true;
        return false;
    }
    
	public static void main(String[] args) {
		System.out.println(isValid("({})"));
	}

}
