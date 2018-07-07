class Solution {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return valid(s.substring(start + 1, end + 1)) || valid(s.substring(start, end));
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
    
    public boolean valid(String s){
        int start = 0, end = s.length() - 1;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}