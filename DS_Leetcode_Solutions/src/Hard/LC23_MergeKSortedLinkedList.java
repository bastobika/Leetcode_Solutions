package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/* You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
*/

public class LC23_MergeKSortedLinkedList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	class MyComparator implements Comparator<ListNode>{
        
        @Override
        public int compare(ListNode a,ListNode b){
            if(a.val >= b.val)
                return 1;
            return -1;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new MyComparator());
        ListNode result = null;
        ListNode temp = result;
        for(int i=0;i<lists.length;i++)
            if(lists[i] != null) pq.add(lists[i]);
        while(!pq.isEmpty()){
            ListNode element = pq.poll();
            if(result == null){
                result = element;
                temp = result;
            }else{
                temp.next = element;
                temp = temp.next;
            }
            if(element.next != null)
                pq.add(element.next);
        }
        return result;
    }
    
	public static void main(String[] args) {
		System.out.println("Merge K Sorted Linked Lists");
	}

}
