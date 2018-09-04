class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) >= 2) return false;
        if(s.length() < t.length()){
            String tmp = s;
            s = t;
            t = tmp;
        }
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            if(index < t.length() && s.charAt(i) == t.charAt(index)) index++;
            else {
                return issame(s.substring(i + 1), t.substring(index)) || issame(s.substring(i), t.substring(index + 1)) || issame(s.substring(i + 1), t.substring(index + 1));
            }
        }
        return false;
        
    }
    
    public boolean issame(String s, String t){
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)) return false;
        }
        return true;
    }
}