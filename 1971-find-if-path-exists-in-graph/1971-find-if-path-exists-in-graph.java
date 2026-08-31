class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i< n; i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        dfs(source, adj, visited);

        if(visited[destination]){
            return true;
        }
        return false;
    }
   public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
     visited[node] = true;

     for(int neighbour: adj.get(node)){
        if(!visited[neighbour]){
            dfs(neighbour, adj, visited);
        }
     }
   }
}