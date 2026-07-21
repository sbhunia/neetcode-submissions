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

    private ListNode merge2Lists(ListNode l1, ListNode l2){
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        else if(l1.val<l2.val){
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        } else{
            l2.next = merge2Lists(l1, l2.next);
            return l2;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head=null;
        for(int i=0; i< lists.length; i++){
            head = merge2Lists(head, lists[i]);
        }
        return head;
    }
}
