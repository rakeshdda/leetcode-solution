class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board);
            }
        }
        for (int i = 0; i < rows; i++) {
            if (board[i][cols - 1] == 'O') {
                dfs(i, cols - 1, board);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (board[rows-1][j] == 'O') {
                dfs(rows-1, j, board);
            }
        }
        for(int i=0; i< rows; i++){
            if(board[i][0] =='O'){
                dfs(i, 0, board);
            }
        }

        for(int i=0; i< rows; i++){
            for(int j=0; j< cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] ='X';
                }else if(board[i][j] =='2'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        board[row][col] = '2';

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && board[newRow][newCol] == 'O') {
                dfs(newRow, newCol, board);
            }
        }
    }
}