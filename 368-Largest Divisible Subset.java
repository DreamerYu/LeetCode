class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int[] pre = new int[nums.length];
        int[] count = new int[nums.length];
        
        
        Arrays.fill(pre, -1);
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    if(count[j] + 1 > count[i]){
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
                
            }
        }
        int index = 0, max = 0;
        for(int i = 0; i < nums.length; i++){
            if(count[i] > max){
                max = count[i];
                index = i;
            }
        }
        
        while(index != -1){
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
        
    }
}