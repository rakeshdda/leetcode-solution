class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
         int oldColor = image[sr][sc];
      
         if(oldColor == color){
            return image;
         }  
        
      
      dfs(sr, sc, color, oldColor, image);
        

        return image;
        }

    public void dfs(int row, int col, int color, int startPixel, int[][] image) {
        int rows = image.length;
        int cols = image[0].length;

        image[row][col] = color;

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && image[newRow][newCol] == startPixel) {
                dfs(newRow, newCol, color, startPixel, image);
            }
        }
    }
}