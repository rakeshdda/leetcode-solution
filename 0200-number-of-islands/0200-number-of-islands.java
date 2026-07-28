class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int count =0;

        for(int i =0; i< rows; i++){
            for(int j=0; j< cols; j++){
                if(grid[i][j] =='1' && !visited[i][j]){
                    dfs(i,j, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        visited[row][col] = true;

        int rows = grid.length;
        int cols = grid[0].length;

        //for up
        int newRow = row - 1;
        int newCol = col;

        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]
                && grid[newRow][newCol] == '1') {
            dfs(newRow, newCol, grid, visited);
        }

        //for right
        newRow = row;
        newCol = col + 1;

        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]
                && grid[newRow][newCol] == '1') {
            dfs(newRow, newCol, grid, visited);
        }

        //for down
        newRow = row + 1;
        newCol = col;

        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]
                && grid[newRow][newCol] == '1') {
            dfs(newRow, newCol, grid, visited);
        }

        //for left

        newRow = row;
        newCol = col - 1;

        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]
                && grid[newRow][newCol] == '1') {
            dfs(newRow, newCol, grid, visited);
        }
    }
}