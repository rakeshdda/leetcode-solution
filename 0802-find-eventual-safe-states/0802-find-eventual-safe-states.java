class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int V = graph.length;

       for(int i =0; i< V; i++){
        adj.add(new ArrayList<>());
       }

       for(int i=0; i< V; i++){
          for(int node: graph[i]){
            int u = i;
            
            int v =node;

            adj.get(v).add(u);;
          }
       }

        int[] indi = new int[V];

        for(int i =0; i< V; i++){
            for(int neighbour : adj.get(i)){
                indi[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i =0; i< V; i++){
            if(indi[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            int curr = queue.poll();

            result.add(curr);

            for(int neighbour: adj.get(curr)){
                indi[neighbour]--;

                if(indi[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
    Collections.sort(result);

    return result;
    }
}