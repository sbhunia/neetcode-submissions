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
    Map<Integer, Node> nodeMap = new HashMap<Integer,Node>();
    
    // we are going to use DFS to clone nodes.
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        // check if the node is already in the hasset.
        // if so then return
        if(nodeMap.containsKey(node.val))
            return nodeMap.get(node.val);
        //create a clone node with value and add to the map
        Node cNode = new Node(node.val);
        nodeMap.put(node.val, cNode);

        // now get all the neighbors and add clne to cNode
        for(Node neighbor : node.neighbors){
            cNode.neighbors.add(cloneGraph(neighbor));
        }
        return cNode;
    }
}