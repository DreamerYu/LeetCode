class Solution {
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }else matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int[] d : dirs){
                int x = now[0] + d[0];
                int y = now[1] + d[1];
                if(x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[now[0]][now[1]] + 1) continue;
                queue.offer(new int[]{x, y});
                matrix[x][y] = matrix[now[0]][now[1]] + 1;
            }
        }
        return matrix;
        
    }
}