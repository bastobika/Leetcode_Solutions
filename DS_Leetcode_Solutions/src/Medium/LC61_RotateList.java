package Medium;

/* Given the head of a linked list, rotate the list to the right by k places.*/

public class LC61_RotateList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        ListNode temp1 = head;
        int size = 0;
        while(temp1 != null){
            temp1 = temp1.next; size++;
        }
        
        //reduces multiple traversal of the list in case where k is greater than length of the list - Improves TC a lot
        k %= size;   
        ListNode temp2 = head;
        temp1 = head;
        for(int i=0;i<k;i++)
            temp1 = temp1.next;
        while(temp1.next != null){
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        temp1.next = head;
        head = temp2.next;
        temp2.next = null;
        return head;            
    }
	
	public static void main(String[] args) {
		System.out.println("Rotate linked list k times");
	}

}
