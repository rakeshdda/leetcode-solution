class Solution {
    class Pair{
        int row ;
        int col ;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
    }
    public int orangesRotting(int[][] grid) {
        int m= grid.length;
        int n = grid[0].length;

        int freshOrange =0;

        Queue<Pair> queue = new LinkedList<>();

        for(int i =0; i< m; i++){
            for(int j =0; j< n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i,j));
                }else if(grid[i][j] == 1){
                    freshOrange++;
                }
            }
        }
        if(freshOrange == 0){
            return 0;
        }
        
        int [] dr = {-1,0,1,0};
        int [] dc = {0,1,0,-1};

        int count =0;

        while(!queue.isEmpty()){

            int qSize = queue.size();

            while(qSize-- >0){
            Pair current = queue.poll();

            int row= current.row;
            int col = current.col;

            for(int k =0; k< 4; k++){
                int newRow = row + dr[k];
                int newCol = col + dc[k];


                if(newRow >=0 && newRow< m && newCol >=0 && newCol < n){
                    if(grid[newRow][newCol] == 1){
                        grid[newRow][newCol] =2;
                        queue.offer(new Pair(newRow, newCol));
                        freshOrange--;
                    }
                }
            }
        } 
        count++;
        }
         if(freshOrange != 0){
            return -1;
         }

        return count-1;
    }
}