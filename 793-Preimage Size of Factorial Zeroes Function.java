class Solution {
    public int preimageSizeFZF(int k) {
        return findrange(k) - findrange(k - 1);
    }
    
    public int findrange(int k){
        long low = 0, high = Long.MAX_VALUE;
        while(low <= high){
            long mid = low + (high - low) / 2;
            if(getzeros(mid) <= k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return (int)low - 1;
    }
    
    public long getzeros(long num){
        long count = 0;
        for(long i = 5; num / i >= 1; i = i * 5){
            count += num / i;
        }
        return count;
    }
}