class WordDictionary {
    class Node{
        Map<Character,Node> children;
        boolean isEndOfWord;
        public Node(Map<Character,Node>  children){
            this.children = children;
            this.isEndOfWord = false;
        }
        public Node(){
            this(new HashMap<Character,Node>());
        }
    }
    Node root;
    
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        addWord(this.root, word, 0);
    }
    
    void addWord(Node node, String word, int chIndex){
        if(chIndex==word.length()){ // end of string
            node.isEndOfWord=true;
            return;
        }
        char ch = word.charAt(chIndex);
        Node child = node.children.get(ch);
        if(child==null){
            child = new Node();
            node.children.put(ch, child);
        }
        addWord(child, word, chIndex+1);
    }

    boolean search(Node node, String word, int chIndex){
        if(chIndex==word.length())
            return node.isEndOfWord;
        char ch = word.charAt(chIndex);
        if(ch=='.'){
            for(Node child: node.children.values()){
                if(search(child, word, chIndex+1))
                    return true;
            }
            return false;
        } else{
            Node child = node.children.get(ch);
            if(child==null)
                return false;
            return search(child, word, chIndex+1);
        }
    }

    public boolean search(String word) {
        return this.search(this.root, word, 0);
    }
}
