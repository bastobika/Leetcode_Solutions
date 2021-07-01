package Easy;

/* Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
 * If the two linked lists have no intersection at all, return null. 
 */

public class LC160_IntersectionOfTwoLinkedLists {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == headB)
            return headA;
        int lengthA = length(headA);
        int lengthB = length(headB);
        ListNode longer = lengthA > lengthB ? headA : headB;
        ListNode shorter = longer == headA ? headB : headA;
        for(int i=0;i<Math.abs(lengthA-lengthB);i++)
            longer = longer.next;
        while(longer != null && shorter != null && longer != shorter){
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;
    }
    
    private int length(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    
	public static void main(String[] args) {
		System.out.println("Intersection of two Linked Lists");
	}

}
