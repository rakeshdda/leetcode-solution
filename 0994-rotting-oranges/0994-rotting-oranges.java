class Solution {
    class Pair{
        int row;
        int col;
    
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
    }
    public int orangesRotting(int[][] grid) {
    int m= grid.length;
    int n= grid[0].length;
    
    Queue<Pair> queue = new LinkedList<>();

    int freshOrange =0;

    for(int i =0; i< m; i++){
        for(int j=0; j< n; j++){

            if(grid[i][j] == 2){
                queue.offer(new Pair(i, j));
            }
            else if(grid[i][j] == 1){
                freshOrange++;
            }

        }
    }
    if(freshOrange ==0){
        return 0;
    }

    int minute =0;

    while(!queue.isEmpty()){
        
        int qSize = queue.size();

        for(int i=0; i< qSize; i++){
            Pair current =queue.poll();

            int row = current.row;
            int col = current.col;

            int [] dr ={-1,0,1,0};
            int [] dc ={0, 1,0, -1};

            for(int j=0; j< 4; j++){
                int newRow =row + dr[j];
                int newCol = col + dc[j];


                if(newRow >=0 && newRow < m && newCol >=0 && newCol < n && grid[newRow][newCol] == 1){
                    grid[newRow][newCol] = 2;

                    queue.offer(new Pair(newRow, newCol));

                    freshOrange--;
                }
            }
        }
        minute++;
    }

    if(freshOrange != 0){
        return -1;
    }

    return minute -1;
    }
}