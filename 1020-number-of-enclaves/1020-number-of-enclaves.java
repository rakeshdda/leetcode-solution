class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int j=0; j< cols; j++){
            if(grid[0][j] == 1){
                dfs(0, j, grid);
            }
        }

        for(int i=0; i< rows; i++){
            if(grid[i][cols-1] == 1){
                dfs(i, cols-1, grid);
            }
        }

        for(int j=0; j< cols; j++){
            if(grid[rows-1][j] == 1){
                dfs(rows-1, j, grid);
            }
        }

        for(int i=0; i< rows; i++){
            if(grid[i][0] == 1){
                dfs(i, 0, grid);
            }
        }


        int count =0;

        for(int i=0; i< rows; i++){
            for(int j =0; j< cols; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int row, int col, int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        grid[row][col] =-1;

        int [] dr ={-1, 0, 1, 0};
        int [] dc ={0, 1, 0, -1};

        for(int i=0; i< 4; i++){
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if(newRow >=0 && newRow < rows && newCol >=0 && newCol < cols && grid[newRow][newCol] == 1){
                dfs(newRow, newCol, grid);
            }
        }
    }
}