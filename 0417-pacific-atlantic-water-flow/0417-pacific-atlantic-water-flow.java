class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int j=0;  j< cols; j++){
            dfs(0, j,  heights, pacific);
            dfs(rows-1, j, heights, atlantic);
        }

        for(int i=0; i< rows; i++){
            dfs(i, 0, heights, pacific);
            dfs(i, cols-1,heights, atlantic);
        }

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i< rows; i++){
            for(int j=0; j< cols; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }

        return list;
    }

    public void dfs(int row, int col , int[][] heights, boolean[][] visited){
        int rows = heights.length;
        int cols = heights[0].length;

        visited[row][col] = true;

        int[] dr = {-1, 0, 1, 0};
        int [] dc = { 0, 1, 0, -1};

        for(int i=0; i< 4; i++){
            int newRow= row + dr[i];
            int newCol= col + dc[i];

            if(newRow >=0 && newRow <rows && newCol>=0 && newCol <cols && heights[row][col] <= heights[newRow][newCol] && !visited[newRow][newCol]){
                dfs(newRow, newCol, heights, visited);
            }
        }
    }
}