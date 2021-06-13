package Easy;

/*Given the head of a singly linked list, reverse the list, and return the reversed list.*/

public class LC206_ReverseLinkedList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	 
	public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp2 = null;
        while(head != null){
            temp2 = head.next;
            head.next = prev;
            prev = head;
            head = temp2;
        }
        return prev;
    }
	
	public ListNode reverseListRecursive(ListNode head,ListNode prev){
        if(head == null)
            return prev;
        ListNode temp = head.next;
        head.next = prev;
        prev = head;
        return reverseListRecursive(temp,prev);
    }
	
	public static void main(String[] args) {
		System.out.println("Reverse Linked List (Both Iterative and Recursive");
	}

}
