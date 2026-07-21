/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer,Node> hm = new HashMap<Integer, Node>();

    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        Node nCopy =hm.get(node.val);
        if(nCopy==null){
            nCopy = new Node(node.val);
            hm.put(node.val, nCopy);
            for(Node n: node.neighbors){
            nCopy.neighbors.add(cloneGraph(n));
            }
        }
        return nCopy;
    }
}