class Solution {
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {

                    if (dfs(i, j, -1, -1, grid[i][j], visited, grid)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int row, int col, int oldRow, int oldCol, char original, boolean[][] visited,
            char[][] grid) {

        visited[row][col] = true;

        int rows = grid.length;
        int cols = grid[0].length;

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        
        for(int i=0; i< 4; i++){

            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if(newRow <0 || newRow >= rows || newCol <0 || newCol >= cols ){
                continue;
            }

            if(grid[newRow][newCol] != original){
                continue;
            }


            if(!visited[newRow][newCol]){
                if(dfs(newRow, newCol, row, col, grid[row][col], visited, grid)){
                    return true;
                }
            }else if(newRow != oldRow || newCol != oldCol){
                return true;
            }
        }
        return false;
    }
}