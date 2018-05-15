class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        if(n == 0) return 0;
        int area = 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '0') continue;
                else{
                    if(j == 0) dp[i][j] = 1;
                    else{
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                    int x = 1;
                    int y = n;
                    while(i - x + 1 >= 0 && dp[i - x + 1][j] > 0){
                        y = Math.min(y, dp[i - x + 1][j]);
                        area = Math.max(area, x * y);
                        x++;
                    }
                }
            }
        }
        return area;
        
    }
}