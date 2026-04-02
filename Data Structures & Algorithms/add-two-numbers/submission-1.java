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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while (l1!=null&&l2!=null){
            int total = (l1.val+l2.val+carry);
            if (total<10){
                carry = 0;
            }
            else if (total>=10){
                carry = total/10;
            }
            temp.next = new ListNode(total%10);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1!=null){
            while (l1!=null){
                int total = l1.val+carry;
                temp.next = new ListNode((total)%10);
                if (total>=10){
                    carry = total/10;
                }
                else if (total<10){
                carry = 0;
                }
                temp = temp.next;
                l1 = l1.next;
            }
            
        }
        else{
            while (l2!=null){
                int total = l2.val+carry;
                temp.next = new ListNode((total)%10);
                if (total>=10){
                    carry = total/10;
                }
                else if (total<10){
                carry = 0;}
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if (carry!=0){
            temp.next = new ListNode(carry);
            temp = temp.next;
        }
        return dummy.next;
    }
}
