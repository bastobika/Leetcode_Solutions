package Easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. 
 * Return the destination city, that is, the city without any path outgoing to another city.
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
*/

public class LC1436_DestinationCity {

	public String destCity(List<List<String>> paths) {     
        Set<String> src = new HashSet<String>();
        for(int i=0;i<paths.size();i++)
            src.add(paths.get(i).get(0));
        for(int i=0;i<paths.size();i++)
            if(!src.contains(paths.get(i).get(1)))
                return paths.get(i).get(1);
        return "";
    }
	
	public static void main(String[] args) {
		System.out.println("Destination City");
	}

}
