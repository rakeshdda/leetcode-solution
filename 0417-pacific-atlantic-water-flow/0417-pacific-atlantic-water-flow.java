class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];

        boolean[][] atlantic = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            dfs(0, j, Integer.MIN_VALUE, heights, pacific);
            dfs(m - 1, j, Integer.MIN_VALUE, heights, atlantic);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, 0, Integer.MIN_VALUE, heights, pacific);
            dfs(i, n - 1, Integer.MIN_VALUE, heights, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    public void dfs(int row, int col, int previous, int[][] heights, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;

        visited[row][col] = true;

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]
                    && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, heights[row][col], heights, visited);
            }
        }

    }
}