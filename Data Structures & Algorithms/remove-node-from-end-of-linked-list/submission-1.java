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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        int count = 0;
        while (first!=null){
            if (count>n){
                second = second.next;
            }
            first = first.next;
            count++;
        }
        ListNode next = second.next;
        second.next = next.next;
        return dummy.next;    
    }
}
