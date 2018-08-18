class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int[] chs = new int[26];
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            chs[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(chs[i] < k && chs[i] != 0) set.add((char) ('a' + i));
        }
        
        if(set.isEmpty()) return s.length();
        
        int start = 0, max = 0;
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i)) || i == s.length() - 1){
                if(start == i){
                    start = i + 1;
                    continue;
                }
                if(set.contains(s.charAt(i))) max = Math.max(max, longestSubstring(s.substring(start, i), k));
                else max = Math.max(max, longestSubstring(s.substring(start, i + 1), k));
                start = i + 1;
            }
        }
        return max;
        
    }
}