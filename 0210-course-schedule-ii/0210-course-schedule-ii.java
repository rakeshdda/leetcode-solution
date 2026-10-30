class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V =numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i< V; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] arr : prerequisites){
            int u=arr[0];
            int v= arr[1];

            adj.get(v).add(u);
        }

     ArrayList<Integer> list = new ArrayList<>();
     Queue<Integer> queue = new LinkedList<>();
      int count =0;

     int[] indigree = new int[V];

     for(int u=0; u< V; u++){
        for(int neighbour : adj.get(u)){
            indigree[neighbour]++;
        }
     }

     for(int i=0; i< V; i++){
        if(indigree[i] == 0){
            queue.offer(i);
        }
     }
    

     while(!queue.isEmpty()){
        int curr = queue.poll();

        list.add(curr);
        count++;

        for(int node: adj.get(curr)){
            indigree[node]--;

            if(indigree[node] == 0){
                queue.offer(node);
            }
        }
     }
    if(count != V){
        return new int[0];
    }
     int [] ans = new int[V];
    
     for(int i=0; i< list.size(); i++){
        ans[i] = list.get(i);
     }

     return ans;
  }
}