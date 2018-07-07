class Solution {
    public int[][] imageSmoother(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[M.length][M[0].length];
        
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                int count = 0;
                for(int a = i - 1; a <= i + 1; a++){
                    for(int b = j - 1; b <= j + 1; b++){
                        if(a >= 0 && a < M.length && b >=0 && b < M[0].length){
                            ans[i][j] += M[a][b];
                            count++;
                        }
                    }
                }
                ans[i][j] /= count;
            }
        }
        return ans;
    }
}