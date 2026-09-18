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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
        // no need to do any reordering as there is less than 2 elements.
            return; 

        ListNode slow,fast;
        slow = head;
        fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is the cut point.

        ListNode prev = null;
        ListNode cur = slow.next;
        
        slow.next=null; // make the first half end at slow node
        
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur=next;
        }

        ListNode second_rev = prev;
        ListNode first = head;    
        // Now we need to merge two list starting from head and second_rev

        cur=null;
        while(first!=null & second_rev!=null){
            cur= first;
            first=first.next;
            
            cur.next = second_rev;
            
            cur = second_rev;
            second_rev = second_rev.next;
            cur.next=first;;
            
        }
        if(first!=null)
            cur.next = first;
        if(second_rev!=null)
            cur.next = second_rev;

    }
}
