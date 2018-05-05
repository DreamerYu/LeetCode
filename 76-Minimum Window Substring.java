class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }
        
        int left = 0;
        int minleft = 0;
        int minlen = s.length() + 1;
        int count = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) >= 0){
                    count++;
                }
                
                while(count == t.length()){
                    if(right - left + 1 < minlen){
                        minleft = left;
                        minlen = right - left + 1;
                    }
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if(map.get(s.charAt(left)) > 0){
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        
        if(minlen > s.length()){  
            return "";  
        }  

        return s.substring(minleft, minleft + minlen);
    }
}