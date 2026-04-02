/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverse(ListNode l){
        ListNode prev=null;
        ListNode curr = l;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return  prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode l2 = reverse(second);
        ListNode l1 = head;
        while (l1!=null && l2!=null){
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            l2.next = n1;
            l1 = n1;
            l2= n2;
        } 
    }
}
