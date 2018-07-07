class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] maxIdx = new int[digits.length];
        int maxPos = digits.length - 1;
        maxIdx[maxPos] = maxPos;
        
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] > digits[maxPos]) {
                maxPos = i;
            }
            maxIdx[i] = maxPos;
        }
        
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != digits[maxIdx[i]]) {
                char tmp = digits[i];
                digits[i] = digits[maxIdx[i]];
                digits[maxIdx[i]] = tmp;
                return Integer.parseInt(String.valueOf(digits));
            }
        }
        
        return num;
        
    }
}