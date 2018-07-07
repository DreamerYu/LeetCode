class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int srow = board.length;
        int scol = board[0].length;
        Queue<Point> queue = new LinkedList<>();
        
        for(int i = 0; i < srow; i++){
            if(board[i][0] == 'O'){
                board[i][0] = '+';
                queue.add(new Point(i, 0));
            }
            if(board[i][scol - 1] == 'O'){
                board[i][scol - 1] = '+';
                queue.add(new Point(i, scol - 1));
            }
        }
        
        for(int i = 0; i < scol; i++){
            if(board[0][i] == 'O'){
                board[0][i] = '+';
                queue.add(new Point(0, i));
            }
            if(board[srow - 1][i] == 'O'){
                board[srow - 1][i] = '+';
                queue.add(new Point(srow - 1, i));
            }
        }
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            int row = p.x;
            int col = p.y;
            if(row - 1 >= 0 && board[row - 1][col] == 'O'){board[row - 1][col] = '+'; queue.add(new Point(row - 1, col));}
            if(row + 1 < srow && board[row + 1][col] == 'O'){board[row + 1][col] = '+'; queue.add(new Point(row + 1, col));}
            if(col - 1 >= 0 && board[row][col - 1] == 'O'){board[row][col - 1] = '+'; queue.add(new Point(row, col - 1));}
            if(col + 1 < scol && board[row][col + 1] == 'O'){board[row][col + 1] = '+'; queue.add(new Point(row, col + 1));}
        }
        for(int i = 0; i < srow; i++){
            for(int j = 0; j < scol; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '+') board[i][j] = 'O';
            }
        }
        
        
        
    }
}