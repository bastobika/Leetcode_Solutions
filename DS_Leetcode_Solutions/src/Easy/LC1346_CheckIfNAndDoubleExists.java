package Easy;

import java.util.HashSet;
import java.util.Set;

/* Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 * More formally check if there exists two indices i and j such that :
 * 		1. i != j
 * 		2. 0 <= i, j < arr.length
 * 		3. arr[i] == 2 * arr[j]
*/
public class LC1346_CheckIfNAndDoubleExists {

	public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i]*2) || (arr[i]%2 == 0 &&set.contains(arr[i]/2)))
                return true;
            set.add(arr[i]);
        }
        return false;
    }
	
	public static void main(String[] args) {
		int arr[] = {10,2,5,6};
		System.out.println(checkIfExist(arr));
	}

}
