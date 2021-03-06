package Medium;

import java.util.List;

/* There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room. 
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  
 * A key rooms[i][j] = v opens the room with number v. Initially, all the rooms start locked (except for room 0). 
 * You can walk back and forth between rooms freely. Return true if and only if you can enter every room.
*/

public class LC841_KeysAndRooms {

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        dfs(rooms,0,visited);
        for(int i=0;i<rooms.size();i++)
            if(!visited[i])
                return false;
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms, int src, boolean visited[]){
        visited[src] = true;
        for(int i=0;i<rooms.get(src).size();i++)
            if(!visited[rooms.get(src).get(i)])
                dfs(rooms,rooms.get(src).get(i),visited);
    }
    
	public static void main(String[] args) {
		System.out.println("Keys and Rooms");
	}

}
