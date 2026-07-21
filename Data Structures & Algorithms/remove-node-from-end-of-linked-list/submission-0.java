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
        if(head==null)
            return head;

        int count=0;
        for(ListNode cur=head; cur!=null; cur=cur.next)
            count++;
        
        int prevPos = count-n;
        if(prevPos==0){
            head=head.next;
            return head;
        }
        
        ListNode cur = head;
        for(int i =1; i<prevPos; i++){
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return head;
    }
}
