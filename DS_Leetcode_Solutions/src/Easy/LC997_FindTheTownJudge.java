package Easy;

/* In a town, there are n people labelled from 1 to n.  There is a rumor that one of these people is secretly the town judge.
 * If the town judge exists, then:
 * 			1. The town judge trusts nobody.
 * 			2. Everybody (except for the town judge) trusts the town judge.
 * 			3. There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
*/

public class LC997_FindTheTownJudge {

	public static int findJudge(int n, int[][] trust) {
        boolean notJudge[] = new boolean[n];
        for(int i=0;i<trust.length;i++)
            notJudge[trust[i][0]-1] = true;
        int count = 0;
        int judge = -1;
        for(int i=0;i<n;i++)
            if(!notJudge[i]){
                count++;
                judge = i+1;
            }
        if(count == 1){
            int trusts = 0;
            for(int i=0;i<trust.length;i++)
                if(trust[i][1] == judge)
                    trusts++;
            if(trusts == n-1)
                return judge;
        }        
        return -1;
    }
	
	public static void main(String[] args) {
		int[][] trust = {{1,3},{2,3},{1,2}};
		System.out.println(findJudge(3,trust));
	}

}
