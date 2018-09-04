class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int[] p = new int[nums.length];
        p[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            p[i] = nums[i] + p[i - 1];
        }
        
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < p.length; i++){
            if(map.containsKey(p[i] - k)){
                max = Math.max(max, i - map.get(p[i] - k));
            }
            if(map.containsKey(p[i])) map.put(p[i], Math.min(i, map.get(p[i])));
            else map.put(p[i], i);
        }
        return max;
        
    }
}