class Solution {
    class Pair{
        int row;
        int col ;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int[][] dist = new int[m][n];

        for(int i =0; i< m ; i++){
            for(int j=0; j< n; j++){

                if(mat[i][j] == 0){
                    dist[i][j] =0;
                    queue.offer(new Pair(i, j));
                }
                else{
                    dist[i][j] = -1;
                }
            }
        }

        int []dr = {-1,0,1,0};
        int []dc = {0,1,0,-1};

        while(!queue.isEmpty()){
            
            Pair current = queue.poll();

            int row =current.row;
            int col = current.col;

            for(int i =0; i< 4; i++){
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if(newRow >=0 && newRow < m && newCol >=0 && newCol < n){
                    if(dist[newRow][newCol] == -1){
                    dist[newRow][newCol] = dist[row][col] +1;
                    queue.offer(new Pair(newRow, newCol));
                }
                }
            }
        }
        return dist;
    }
}