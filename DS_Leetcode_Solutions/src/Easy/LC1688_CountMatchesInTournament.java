package Easy;

/* You are given an integer n, the number of teams in a tournament that has strange rules:
 * 			1. If the current number of teams is even, each team gets paired with another team. 
 * 				A total of n / 2 matches are played, and n / 2 teams advance to the next round.
*			2. If the current number of teams is odd, one team randomly advances in the tournament, and the rest gets paired. 
*				A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.
* Return the number of matches played in the tournament until a winner is decided.
*/

public class LC1688_CountMatchesInTournament {

	public static int numberOfMatches(int n) {
        return n-1;
    }
	
	public static void main(String[] args) {
		System.out.println(numberOfMatches(13));
	}

}
