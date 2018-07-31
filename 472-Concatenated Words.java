class Solution {
    class trie{
        public trie(){
            child = new trie[26];
            word = null;
        }
        trie[] child;
        String word;
    }
    
    trie root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        root = new trie();
        for(int i = 0; i < words.length; i++){
            put(words[i]);
        }
        
        for(String word : words){
            if(dfsistrue(word.toCharArray(), 0, 0)){
                res.add(word);
            }
        }
        return res;
        
    }
    
    public boolean dfsistrue(char[] chs, int index, int count){
        trie node = root;
        for(int i = index; i < chs.length; i++){
            if(node.child[chs[i] - 'a'] == null){
                return false;
            }else{
                if(node.child[chs[i] - 'a'].word != null){
                    if(i == chs.length - 1){
                        return count >= 1;
                    }
                    if(dfsistrue(chs, i + 1, count + 1)){
                        return true;
                    }
                    
                }
                
            }
            node = node.child[chs[i] - 'a'];
        }
        return false;
    }
    
    public void put(String st){
        trie node = root;
        for(int i = 0; i < st.length(); i++){
            if(node.child[st.charAt(i) - 'a'] == null){
                node.child[st.charAt(i) - 'a'] = new trie();
            }
            node = node.child[st.charAt(i) - 'a'];
            if(i == st.length() - 1) node.word = st;
        }
    }
    
}