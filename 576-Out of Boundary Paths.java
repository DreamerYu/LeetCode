class Solution {
    long mm = 1000000007;
    public int findPaths(int m, int n, int N, int i, int j) {
        long[][][] memo = new long[m][n][N + 1];
        
        for(long[][] l : memo){
            for(long[] k : l){
                Arrays.fill(k, -1);
            }
        }
        return (int)findpath(m, n, N, i, j, memo);
        
    }
    
    public long findpath(int m, int n, int N, int i, int j, long[][][] memo){
        if(i < 0 || j < 0 || i >= m || j >= n) return 1;
        
        if(N == 0) return 0;
        
        if(memo[i][j][N] >= 0) return memo[i][j][N];
        
        memo[i][j][N] = (findpath(m, n, N - 1, i - 1, j, memo) + findpath(m, n, N - 1, i + 1, j, memo) + findpath(m, n, N - 1, i, j - 1, memo) + findpath(m, n, N - 1, i, j + 1, memo)) % mm;
        return memo[i][j][N];
    }
}