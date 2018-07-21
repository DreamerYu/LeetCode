class Solution {
    //!!!!!! Arrays.equals
    
    public boolean reorderedPowerOf2(int N) {
        int[] a = count(N);
        for(int i = 0; i < 31; i++){
            if(Arrays.equals(a, count(1 << i))){
                return true;
            }
        }
        return false;
    }
    
    public int[] count(int n){
        int[] ans = new int[10];
        while(n != 0){
            ans[n % 10]++;
            n /= 10;
        }
        return ans;
    }
}