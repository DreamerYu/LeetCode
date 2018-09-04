class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        return ismatch(pattern, 0, str, 0, map, set);
        
    }
    
    public boolean ismatch(String p, int indexp, String str, int indexs, HashMap<Character, String> map, HashSet<String> set){
        if(indexp == p.length() && indexs == str.length()) return true;
        if(indexp >= p.length() || indexs >= str.length()) return false;
        if(map.containsKey(p.charAt(indexp))){
            String s = map.get(p.charAt(indexp));
            if(str.substring(indexs).startsWith(s)){
                if(ismatch(p, indexp + 1, str, indexs + s.length(), map, set)) return true;
            }else return false;
        }else{
            for(int i = indexs + 1; i <= str.length(); i++){
                map.put(p.charAt(indexp), str.substring(indexs, i));
                if(set.add(str.substring(indexs, i)) && ismatch(p, indexp + 1, str, i, map, set)) return true;
                map.remove(p.charAt(indexp));
                set.remove(str.substring(indexs, i));
            }
        }
        return false;
    }
}