/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;

        Map<Node, Node> map = new HashMap<>();

        //Copy the linked list
        Node prev = new Node(0);
        Node copyHead = prev;

        for(Node cur = head; cur!=null; cur=cur.next){
            Node copy = new Node(cur.val);
            copy.random = cur.random;
            map.put(cur,copy);
            prev.next = copy;
            prev = copy;
        }
        prev.next=null;

        copyHead = copyHead.next;
        

        for(Node cur = copyHead; cur!=null; cur=cur.next){
            if(cur.random!=null)
                cur.random = map.get(cur.random);
        }
        return copyHead;
    }
}
