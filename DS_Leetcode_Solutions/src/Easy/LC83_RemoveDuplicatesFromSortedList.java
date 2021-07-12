package Easy;

/* Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well. */

public class LC83_RemoveDuplicatesFromSortedList {

	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null){
            while(temp.next != null && temp.val == temp.next.val)
                temp.next = temp.next.next;
            temp = temp.next;
        }
        return head;
    }
	
	public static void main(String[] args) {
		System.out.println("Remove Duplicates From Sorted Linked List");
	}

}
