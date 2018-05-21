class Solution {
    public String shortestPalindrome(String s) {
        int j = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == s.charAt(j)) j++;
        }
        if(j == s.length()) return s;
        String suffix = s.substring(j);
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
//         int start = 0;
//         for(int i = s.length() - 1; i >= 0; i--){
//             if(isPalindrome(s, i)){
//                 start = i;
//                 break;
//             }
//         }
//         String add = start == s.length() ? "" : new StringBuilder(s.substring(start + 1)).reverse().toString();
//         return add + s;
        
//     }
    
//     public boolean isPalindrome(String s, int end){
//         int start = 0;
//         while(start <= end){
//             if(s.charAt(start++) != s.charAt(end--)) return false;
//         }
//         return true;
    }
}