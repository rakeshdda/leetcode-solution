class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;

        int proviences =0;

        boolean [] visited = new boolean[n];

        for(int i=0; i< n; i++){
            if(!visited[i]){
                dfs(i, isConnected, visited);
                proviences++;
            }
        }
        return proviences;
    }
    public void dfs(int city, int[][] matrix,boolean[] visited){
        visited[city] = true;

        for (int neighbour =0; neighbour< matrix.length; neighbour++){
            if(matrix[city][neighbour] == 1 && !visited[neighbour]){
                dfs(neighbour, matrix, visited);
            }
        }
    }
}