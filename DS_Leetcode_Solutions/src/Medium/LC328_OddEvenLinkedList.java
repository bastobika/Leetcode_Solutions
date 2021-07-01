package Medium;

/* Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
*/

public class LC328_OddEvenLinkedList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null;
        ListNode evenHead = null;
        ListNode oddEnd = null;
        ListNode evenEnd = null;
        int i = 1;
        while(head != null){
            if(i%2 == 0){
                if(evenHead == null){
                    evenHead = head;
                    evenEnd = evenHead;
                }else{
                    evenEnd.next = head;
                    evenEnd = evenEnd.next;
                }
            }else{
                if(oddHead == null){
                    oddHead = head;
                    oddEnd = oddHead;
                }else{
                    oddEnd.next = head;
                    oddEnd = oddEnd.next;
                }
            }
            head = head.next;
            i++;
        }
        if(evenEnd != null)
            evenEnd.next = null;
        if(oddHead == null)    return evenHead;
        oddEnd.next = evenHead;
        return oddHead;
    }
    
	//Efficient - Lesser number of pointers
    public ListNode oddEvenListShorter(ListNode head) {
        if(head == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && odd != null){
            odd.next = even.next;
            even.next = even.next == null ? null : even.next.next;
            odd = odd.next == null ? odd : odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
