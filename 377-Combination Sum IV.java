class Solution {
    public int combinationSum4(int[] nums, int target) {
    int[] comb = new int[target + 1];
    comb[0] = 1;
    for (int i = 1; i < comb.length; i++) {
        for (int j = 0; j < nums.length; j++) {
            if (i - nums[j] >= 0) {
                comb[i] += comb[i - nums[j]];
            }
        }
    }
    return comb[target];
}
    
    // recursion with memo
//     public int combinationSum4(int[] nums, int target) {
//         int[] memo = new int[target + 1];
//         Arrays.fill(memo, -1);
//         memo[0] = 1;
//         help(nums, target, memo);
//         return memo[target];
//     }
    
//     public int help(int[] nums, int target, int[] memo){
//         if(memo[target] != -1) return memo[target];
        
//         int res = 0;
//         for(int i = 0; i < nums.length; i++){
//             if(target >= nums[i]) res += help(nums, target - nums[i], memo);
//         }
//         memo[target] = res;
//         return res;
        
//     }
    
    //time limit exceeded
//     public int combinationSum4(int[] nums, int target) {
//         if(target == 0) return 1;
        
//         int res = 0;
//         for(int i = 0; i < nums.length; i++){
//             if(target >= nums[i]) res += combinationSum4(nums, target - nums[i]);
//         }
//         return res;
//     }
    
    
//     int res = 0;
//     public int combinationSum4(int[] nums, int target) {
        
        
//         help(nums, target);
//         return res;
//     }
    
//     public void help(int[] nums, int target){
//         if(target == 0){
//             res++;
//             return;
//         }
//         if(target < 0) return;
//         for(int i = 0; i < nums.length; i++){
//             help(nums, target - nums[i]);
//         }
//     }
}