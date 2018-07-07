class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] memo = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                // memo[i][j] = dfs(matrix, visited, i, j, memo);
                max = Math.max(max, dfs(matrix, visited, i, j, memo));
            }
        }
        return max;
        
    }
    
    public int dfs(int[][] matrix, boolean[][] visited, int x, int y, int[][] memo){
        if(memo[x][y] != 0) return memo[x][y];
        int len = 1;
        if(x > 0 && matrix[x - 1][y] > matrix[x][y] && !visited[x - 1][y]){
            visited[x - 1][y] = true;
            len = Math.max(len, 1 + dfs(matrix, visited, x - 1, y, memo));
            visited[x - 1][y] = false;
        }
        if(x < matrix.length - 1 && matrix[x + 1][y] > matrix[x][y] && !visited[x + 1][y]){
            visited[x + 1][y] = true;
            len = Math.max(len, 1 + dfs(matrix, visited, x + 1, y, memo));
            visited[x + 1][y] = false;
        }
        if(y > 0 && matrix[x][y - 1] > matrix[x][y] && !visited[x][y - 1]){
            visited[x][y - 1] = true;
            len = Math.max(len, 1 + dfs(matrix, visited, x, y - 1, memo));
            visited[x][y - 1] = false;
        }
        if(y < matrix[0].length - 1 && matrix[x][y + 1] > matrix[x][y] && !visited[x][y + 1]){
            visited[x][y + 1] = true;
            len = Math.max(len, 1 + dfs(matrix, visited, x, y + 1, memo));
            visited[x][y + 1] = false;
        }
        memo[x][y] = len;
        return len;
    }
}