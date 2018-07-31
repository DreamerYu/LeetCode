class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
    
    //ACCEPT, but the initilization is not very good and reasonable.
//     public int change(int amount, int[] coins){
//         int[][] dp = new int[coins.length][amount + 1];
//         dp[0][0] = 1;
        
//         for(int i = 0; i < coins.length; i++){
//             dp[i][0] = 1;
//             for(int j = 1; j <= amount; j++){
//                 dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
//             }
//         }
//         return dp[coins.length - 1][amount];
    
    
    
    //ACCEPT, but the initilization is not very good and reasonable.
    // public int change(int amount, int[] coins) {
    //     int[] dp = new int[amount + 1];
    //     dp[0] = 1;
    //     for (int coin : coins) {
    //         for (int i = coin; i <= amount; i++) {
    //             dp[i] += dp[i-coin];
    //         }
    //     }
    //     return dp[amount];
    // }
    
    
    
    // TLE
//     int count = 0;
//     public int change(int amount, int[] coins) {
//         help(amount, coins, 0);
//         return count;
//     }
//     public void help(int amount, int[] coins, int index){
//         if(amount == 0){
//             count++;
//             return;
//         }
//         if(index == coins.length || coins[index] > amount) return;
        
//         for(int i = amount / coins[index]; i >= 0; i--){
//             help(amount - coins[index] * i, coins, index + 1);
            
//         }
    // }
}