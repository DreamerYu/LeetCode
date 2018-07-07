class Solution {
    
    //Union Find
    
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] mark = new int[m * n + 3];
        int index = 2;
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    union(grid, i, j, index++, mark);
                }
            }
        }
        
        int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (grid[i][j] == 1) continue;
                int area = 1;
                // if(grid[i][j] == 0) area++;
                Set<Integer> set = new HashSet();
                for (int k = 0; k < 4; ++k) {
                    int x = i + d[k][0], y = j + d[k][1];
                    if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0)
                        continue;
                    int f1 = mark[grid[x][y]];
                    if (!set.contains(grid[x][y])) {
                        set.add(grid[x][y]);
                        area = area + f1;
                    }
                }
                if(set.contains(grid[i][j])) area--;
                max = Math.max(area, max);
            }
        }
        return max;
    }
    
    public void union(int[][] grid, int i, int j, int index, int[] mark){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0]. length || grid[i][j] == 0 || grid[i][j] == index) return;
        grid[i][j] = index;
        mark[index]++;
        union(grid, i - 1, j, index, mark);
        union(grid, i + 1, j, index, mark);
        union(grid, i, j - 1, index, mark);
        union(grid, i, j + 1, index, mark);
    }
}