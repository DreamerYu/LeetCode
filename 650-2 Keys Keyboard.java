class Solution {
    //dp solution
    public int minSteps(int n){
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++){
            dp[i] = i;
            for(int j = i - 1; j > 1; j--){
                if(i % j == 0){
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }
        return dp[n];
    }
    
    //Math solution
    public int minSteps2(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}