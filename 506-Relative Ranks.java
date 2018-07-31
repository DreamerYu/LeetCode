class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[][] pair = new int[nums.length][2];
        String[] res = new String[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
        
        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
        
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                res[pair[i][1]] = "Gold Medal";
            }
            
            if(i == 1){
                res[pair[i][1]] = "Silver Medal";
            }
            if(i == 2){
                res[pair[i][1]] = "Bronze Medal";
            }
            if(i > 2){
                res[pair[i][1]] = (i + 1) + "";
            }
        }
        return res;
        
    }
}