class PrefixTree {
    class TNode{
        char c;
        Map<Character, TNode> children;
        public TNode(){
            this('*');
        }
        public TNode(char c){
            this.c=c;
            children = new HashMap<Character, TNode>();
        }
    }
    TNode root;

    public PrefixTree() {
         root = new TNode();
    }

    public void insert(TNode node, String word, int i){
        if(i>=word.length()){
            TNode endChild = new TNode();
            node.children.put('*', endChild);
            return;
        }
        char c  = word.charAt(i);
        if( node.children.containsKey(c)){
            TNode child = node.children.get(c);
            insert(child, word, i+1);
        } else{
            TNode child = new TNode(c);
            node.children.put(c, child);
            insert(child, word, i+1);
        }
    }

    public void insert(String word) {
        insert(root, word , 0);
    }

    private boolean search(TNode node, String word, int i){
        if(i>=word.length())
            return node.children.containsKey('*');
        char c = word.charAt(i);
        if(node.children.containsKey(c)){
            TNode child = node.children.get(c);
            return search(child, word, i+1);
        } else 
            return false;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean startsWith(TNode node, String word, int i){
        if(i>=word.length())
            return true;
        char c = word.charAt(i);
        if(node.children.containsKey(c)){
            TNode child = node.children.get(c);
            return startsWith(child, word, i+1);
        } else 
            return false;
    }
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }
}
