class WordDictionary {
    class TrieNode{
        public TrieNode[] child = new TrieNode[26];
        String item = "";
    }
    
    private TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.child[ch - 'a'] == null){
                node.child[ch - 'a'] = new TrieNode();
            }
            node = node.child[ch - 'a'];
        }
        node.item = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word.toCharArray(), 0);
    }
    
    public boolean match(TrieNode root, char[] ch, int index){
        if(index == ch.length) return !root.item.equals("");
        if(ch[index] != '.'){
            return root.child[ch[index] - 'a'] != null && match(root.child[ch[index] - 'a'], ch, index + 1);
        }else{
            for(int i = 0; i < root.child.length; i++){
                if(root.child[i] != null){
                    if(match(root.child[i], ch, index + 1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */