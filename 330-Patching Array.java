class Solution {
    //1 2 4 6 8 16...能够组成小于3 5 7 9 17的任何数，因为这相当于二进制的每一位取0或者1
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int add = 0, i = 0; 
        while(miss <= n){
            if(i < nums.length && nums[i] <= miss){
                miss += nums[i++];
            }else{
                miss += miss;
                add++;
            }
        }
        return add;
    }
    
}