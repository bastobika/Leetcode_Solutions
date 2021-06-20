package Medium;

/* Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/

public class LC109_ConvertSortedListToBST {

	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
		 
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        root.right = sortedListToBST(mid.next);
        ListNode temp = head;
        while(temp != null && temp.next != mid)
            temp = temp.next;
        if(temp != null)
            temp.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
    
    private ListNode findMid(ListNode head){
        ListNode temp1 = head;
        ListNode temp2 = head;
        while(temp2 != null && temp2.next != null){
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        return temp1;
    }
    
	public static void main(String[] args) {
		System.out.println("Sorted Linked List to BST");
	}

}
