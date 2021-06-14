package Easy;

/* You are given a string s representing an attendance record for a student where each character signifies whether the student was absent, late, or present 
 * on that day. The record only contains the following three characters:
 * 					'A': Absent , 'L': Late ,'P': Present.
 * The student is eligible for an attendance award if they meet both of the following criteria:
 * 				    1. The student was absent ('A') for strictly fewer than 2 days total.
 * 					2. The student was never late ('L') for 3 or more consecutive days.
 * Return true if the student is eligible for an attendance award, or false otherwise. 
 */
public class LC551_StudentAttendanceRecord {

	public static boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'A' && ++absent == 2)
                return false;
            if(s.charAt(i) == 'L'){
                if(++late == 3)
                    return false;
            }else
                late = 0;
        }
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println(checkRecord("PPPLLAL"));
	}

}
