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
    public boolean hasCycle(ListNode head) {
        ListNode single = head;
        if(head.next==null)
            return false;
        ListNode d = head.next; 
        while(d!=null){
            if(single==d)
                return true;
            single = single.next;
            if(d.next==null)
                return false;
            d = d.next.next; 
        }
        return false;
    }
}
