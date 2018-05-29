class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int maxlen = 0;
        for(int i = 0; i < p.length(); i++){
            if(i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i) - p.charAt(i - 1) == -25)){
                maxlen++;
            }else{
                maxlen = 1;
            }
            
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxlen);
        }
        int sum = 0;
        for(int i = 0; i < count.length; i++) sum += count[i];
        return sum;
    }
}