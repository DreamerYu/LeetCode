class Solution {
    
    //dynamic programming
    public double knightProbability(int N, int K, int r, int c) {
        
        double[][][] memo = new double[N][N][K + 1];
        return dfs(r, c, K, N, memo);
        
    }
    
    
    
    //dfs with memoration
    int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
    public double knightProbability(int N, int K, int r, int c) {
        
        double[][][] memo = new double[N][N][K + 1];
        return dfs(r, c, K, N, memo);
        
    }
    
    public double dfs(int x, int y, int k, int N, double[][][] memo){
        if(memo[x][y][k] != 0) return memo[x][y][k];
        if(k == 0){
            return 1.0;
        }
        double res = 0;
        for(int[] d : dir){
            int xc = x + d[0];
            int yc = y + d[1];
            if(xc >= 0 && xc < N && yc >= 0 && yc < N){
                res += dfs(xc, yc, k - 1, N, memo) / 8.0;
            }
        }
        memo[x][y][k] = res;
        return res;
    }
}