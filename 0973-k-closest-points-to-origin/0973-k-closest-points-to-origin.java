class Solution {
    class Pair {
        int dist;
        int point;

        Pair(int dist, int point) {
            this.dist = dist;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxheap = new PriorityQueue<>((a,b) -> b.dist -a.dist);

        for(int i=0; i< k; i++){
            int dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);

           
                maxheap.offer(new Pair(dist, i));
            
        }

        for(int j=k; j< points.length; j++){
            int dist =(points[j][0] * points[j][0]) + (points[j][1] * points[j][1]);

            if(maxheap.peek().dist > dist){
                maxheap.poll();
                maxheap.offer(new Pair(dist, j));
            }
        }

        
         int [][] arr = new int[k][2];

        int m=0;
        while(!maxheap.isEmpty()){
            Pair current = maxheap.poll();

            arr[m] = points[current.point];
         
            m++;
        }

        return arr;
    }
}