package Medium;

import java.util.ArrayDeque;

/* We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
 * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val,
 *  and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
 *  Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
*/

public class LC1019_NextGreaterNodeInLinkedList {

	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	class Pair{
        int index,value;

        Pair(int index,int value){
            this.index = index;
            this.value = value;
        }
    }
    
	
	//You can also store values of the linked list to an array list and do the same. No need to create class Pair
    public int[] nextLargerNodes(ListNode head) {        
        ArrayDeque<Pair> stack = new ArrayDeque<Pair>();
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        int result[] = new int[length];
        temp = head;
        int i = 0;
        while(temp != null){
            while(!stack.isEmpty() && stack.peek().value < temp.val)
                result[stack.pop().index] = temp.val;
            stack.push(new Pair(i++,temp.val));            
            temp = temp.next;
        }
        while(!stack.isEmpty())
            result[stack.pop().index] = 0;
        return result;
    }
    
	public static void main(String[] args) {
		System.out.println("Next greater element in linked list");
	}

}
