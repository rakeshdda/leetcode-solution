class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       	int originalColor = image[sr][sc];
    	
    	// if (originalColor == color){
        //  return image;
        //  }
         
    	dfs(sr,sc, color, image, originalColor);
    	
        return image;
    }
      public void dfs(int row, int col, int color, int[][] image,int originalColor){
    	
    	image[row][col] = color;
    	
    	int rows = image.length;
    	int cols = image[0].length;
    	
       
    	
    	int[] dr = {-1, 0, 1, 0};
    	int[] dc ={ 0, 1, 0, -1};
    	
    	for(int i =0; i<4; i++){
    		int newRow = row + dr[i];
    		int newCol = col + dc[i];
    		
    		
    		if(newRow>= 0 && newRow< rows && newCol >=0 && newCol < cols && image[newRow][newCol] != color && image[newRow][newCol] == originalColor){
    			dfs(newRow, newCol, color, image, originalColor);
    		}
    	}
    // 	//for up
    // 	int newRow = row - 1;
    //     int newCol = col;

    //     if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && image[newRow][newCol] != color
    //             && image[newRow][newCol] == originalColor) {
    //         dfs(newRow, newCol, color, image, originalColor);
    //     }
        
        
    //     //for right
    // 	newRow = row ;
    //     newCol = col + 1;

    //     if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && image[newRow][newCol] != color
    //             && image[newRow][newCol] == originalColor) {
    //         dfs(newRow, newCol, color, image, originalColor);
    //     }
        
    //     //for down
    // 	newRow = row +1 ;
    //     newCol = col;

    //     if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && image[newRow][newCol] != color
    //             && image[newRow][newCol] == originalColor) {
    //         dfs(newRow, newCol, color, image, originalColor);
    //     }
		
	// 	//for left
    // 	newRow = row ;
    //     newCol = col -1;

    //     if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && image[newRow][newCol] != color
    //             && image[newRow][newCol] == originalColor) {
    //         dfs(newRow, newCol, color, image, originalColor);
    //     }
     }
}