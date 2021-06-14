package Easy;

/* Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 * For example:
 * 		A -> 1 , B -> 2 , C -> 3
 *     Z -> 26 , AA -> 27 , AB -> 28 
 */

public class LC168_ExcelColumnSheetTitle {

	public static String convertToTitle(int columnNumber) {
        String result = "";
        while(columnNumber > 0){
            int index = columnNumber%26 == 0 ? 26 : columnNumber%26;
            result = Character.toString((char)(index + 64)) + result;
            columnNumber = columnNumber%26 == 0 ? columnNumber/26 - 1 : columnNumber/26;
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(convertToTitle(702));
	}

}
