package Medium;

import java.util.ArrayDeque;

/* Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number
 *  of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */

public class LC739_DailyTemperatures {
	
	public static int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i])
                temperatures[stack.peek()] = i - stack.pop();
            stack.push(i);
        }
        while(!stack.isEmpty())
            temperatures[stack.pop()] = 0;
        return temperatures;
    }
	
	public static void main(String[] args) {
		int temperatures[] = {73,74,75,71,69,72,76,73};
		System.out.println(dailyTemperatures(temperatures));
	}
	
}
