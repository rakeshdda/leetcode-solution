class Solution {
    public int numEnclaves(int[][] grid) {
        int rows=grid.length;
        int cols = grid[0].length;

        //for top
        for(int col=0; col< cols; col++){
            if(grid[0][col] == 1){
                dfs(0, col, grid);
            }
        }
        //for right
        for(int row=0; row< rows; row++){
            if(grid[row][cols-1] == 1){
                dfs(row, cols-1, grid);
            }
        }
        //for bottom
        for(int col=0; col<cols; col++){
            if(grid[rows-1][col] == 1){
                dfs(rows-1, col, grid);
            }
        }
        //for left
        for(int row=0;row<rows; row++){
            if(grid[row][0] == 1){
                dfs(row, 0, grid);
            }
        }

        int count =0;

        for(int i=0; i< rows; i++){
            for(int j=0; j< cols; j++){
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

        int [] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        grid[row][col] = -1;

        for(int i=0; i< 4; i++){
            int newRow= row+ dr[i];
            int newCol =col + dc[i];

            if(newRow >=0 && newRow < rows && newCol >=0 && newCol < cols && grid[newRow][newCol] == 1){
                dfs(newRow, newCol, grid);
            }
        }
    }

}