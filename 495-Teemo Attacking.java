class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0) return 0;
        int sum = 0;
        for(int i = 1; i < timeSeries.length; i++){
            if(duration <= timeSeries[i] - timeSeries[i - 1]) sum += duration;
            else sum += timeSeries[i] - timeSeries[i - 1];
        }
        return sum + duration;
        
    }
}