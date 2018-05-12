class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int n = matrix.length, m = matrix[0].length;
        boolean[][] paci = new boolean[n][m];
        boolean[][] atlan = new boolean[n][m];
        for(int i = 0; i < n; i++){
            dfs(matrix, paci, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlan, Integer.MIN_VALUE, i, m - 1);
        }
        for(int i = 0; i < m; i++){
            dfs(matrix, paci, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlan, Integer.MIN_VALUE, n - 1, i);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(paci[i][j] && atlan[i][j]){
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }
    
    
    int[][] part = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public void dfs(int[][] matrix, boolean[][] visit, int height, int x, int y){
        int n = matrix.length, m = matrix[0].length;
        if(x < 0 || y < 0 || x >= n || y >= m || visit[x][y] || matrix[x][y] < height) return;
        visit[x][y] = true;
        for(int[] c : part){
            dfs(matrix, visit, matrix[x][y], x + c[0], y + c[1]);
        }
    }
}