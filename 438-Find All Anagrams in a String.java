class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        if(p.length() > s.length()) return res;
        
        for(int i = 0; i < p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        int begin = 0, end = 0;
        int count = map.size();
        
        while(end < s.length()){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) count--;
            }
            end++;
            while(count == 0){
                char temp = s.charAt(begin);
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp) + 1);
                    if(map.get(temp) > 0) count++;
                }
                if(end - begin == p.length()){
                    res.add(begin);
                }
                begin++;
            }
        }
        return res;
    }
}