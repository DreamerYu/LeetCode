class MagicDictionary {
    HashMap<Integer, ArrayList<String>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String st : dict){
            if(map.containsKey(st.length())){
                map.get(st.length()).add(st);
            }else{
                map.put(st.length(), new ArrayList<>());
                map.get(st.length()).add(st);
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(!map.containsKey(word.length())) return false;
        for(String candidate : map.get(word.length())){
            int count = 0;
            for(int i = 0; i < candidate.length(); i++){
                if(word.charAt(i) != candidate.charAt(i)) count++;
                if(count > 1) break;
            }
            if(count == 1) return true;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */