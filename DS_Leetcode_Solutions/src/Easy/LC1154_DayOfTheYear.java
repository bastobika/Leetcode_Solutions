package Easy;

/* Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year. */

public class LC1154_DayOfTheYear {

	public static int dayOfYear(String date) {
        String[] arr = date.split("-");
        int month = Integer.parseInt(arr[1]) - 1;
        int result = Integer.parseInt(arr[2]);
        boolean leapYear = isLeapYear(Integer.parseInt(arr[0]));
        while(month >= 1)
            result += countDays(month--,leapYear);
        return result;
    }
    
    private static int countDays(int month,boolean leapYear){
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8
            || month == 10 || month == 12)
            return 31;
        if(month == 2)
            return leapYear ? 29 : 28;
        return 30;
    }
    
    private static boolean isLeapYear(int year){
        if(year%4 != 0)
            return false;
        else if(year%100 != 0 || (year%100 == 0 && year%400 == 0))
            return true;
        return false;
    }
    
	public static void main(String[] args) {
		System.out.println(dayOfYear("2012-09-12"));
	}

}
