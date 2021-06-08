package Easy;

public class LC509_FibonacciNumber {

	public static int fib(int number) {
        if(number == 0 || number == 1)
            return number;
        int result = 0;
        int prev_prev = 0;
        int prev = 1;
        for(int i=2;i<=number;i++){
            result = prev_prev + prev;
            prev_prev = prev;
            prev = result;
        }   
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(fib(7));
	}

}
