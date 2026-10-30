class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge: prerequisites){
            int u= edge[0];
            int v =edge[1];

            adj.get(v).add(u);
        }
       return checkTopo(V, adj);
    }

public boolean checkTopo(int V, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        int[] indigree = new int[V];

        for(int u=0; u< V; u++){
            for(int neighbour : adj.get(u)){
                indigree[neighbour]++;
            }
        }
        int count =0;

        for(int i=0; i<V; i++){
            if(indigree[i] == 0){
                queue.offer(i);
                count++;
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();


            for(int node: adj.get(curr)){
                indigree[node]--;

                if(indigree[node] == 0){
                    queue.offer(node);
                    count++;
                }
            }
        }

        if(count == V){
            return true;
        }

    return false;
}   
}