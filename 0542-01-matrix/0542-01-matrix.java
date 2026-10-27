class Solution {
    class Pair{
        int row;
        int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
    }
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        Queue<Pair> queue = new LinkedList<>();
        int[][] result = new int[rows][cols];

        for(int i=0; i< rows; i++){
            for(int j=0; j< cols; j++){
                if(mat[i][j] == 0){
                    result[i][j] =0;
                    queue.offer(new Pair(i, j));
                }else{
                    result[i][j] = -1;
                }
           }
        }

        int [] dr ={-1, 0, 1, 0};
        int [] dc ={0, 1, 0,-1};

        while(!queue.isEmpty()){
            Pair curr = queue.poll();

            int row = curr.row;
            int col = curr.col;

            for(int i=0; i< 4; i++){
                int newRow = row + dr[i];
                int newCol = col+ dc[i];

                if(newRow >=0 && newRow < rows && newCol >=0 && newCol <cols && result[newRow][newCol] ==-1){
                        result[newRow][newCol] = result[row][col] +1;
                        queue.offer(new Pair(newRow, newCol));
                }         
               }
        }

        return result;
    }
}