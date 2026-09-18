class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V =numCourses;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i< V; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] edge: prerequisites){
            int u =edge[0];
            int v =edge[1];

            adj.get(v).add(u);
        }

        int[] indi = new int[V];

        for (int i = 0; i < V; i++) {
            for (int neighbour : adj.get(i)) {
                indi[neighbour]++;
            }
        }

        int count =0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i =0; i<V; i++){
            if(indi[i] == 0){
                queue.offer(i);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()){
            int curr = queue.poll();

            list.add(curr);
            count++;

            for(int neighbour: adj.get(curr)){
                indi[neighbour]--;

                if(indi[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }


        if(count  !=V){
            return new int[0];
        }
        
        int [] result= new int[list.size()];

        for(int i=0; i< list.size(); i++){
            result[i] =list.get(i);
        }

       
        return result;
    }
}