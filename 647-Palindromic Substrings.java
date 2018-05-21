class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count += PalindromeNum(s, i);
        }
        return count;
    }
    
    public int PalindromeNum(String s, int core){
        int start = core, end = core;
        int res = 0;
        while(start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) res++;
        start = core; 
        end = core + 1;
        while(start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) res++;
        return res;
    }
}