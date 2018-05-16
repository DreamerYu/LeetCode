class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int len = words[0].length();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], map.containsKey(words[i]) ? map.get(words[i]) + 1 : 1);
        }
        
        for(int i = 0; i <= s.length() - len * words.length; i++){
            HashMap<String, Integer> copy = new HashMap<>(map);
            for(int j = 0; j < words.length; j++){
                String c = s.substring(i + j * len, i + j * len + len);
                if(copy.containsKey(c)){
                    int count = copy.get(c);
                    if(count == 1){
                        copy.remove(c);
                    }else{
                        copy.put(c, count - 1);
                    }
                    if (copy.isEmpty()) {
                        res.add(i);
                        // break;
                    }
                }else break;
            }
        }
        return res;
    }
}