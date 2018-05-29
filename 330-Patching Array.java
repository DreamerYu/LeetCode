class Solution {
    //1 2 4 6 8 16...�ܹ����С��3 5 7 9 17���κ�������Ϊ���൱�ڶ����Ƶ�ÿһλȡ0����1
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