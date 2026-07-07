class Solution {
    class Pair{
        int distance;
        int index;

    Pair(int  distance, int index){
        this.distance = distance;
        this.index = index;
    }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxheap = new PriorityQueue<>((a,b) -> b.distance -a.distance);

        for(int i =0; i< k; i++){
            int dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            maxheap.offer(new Pair(dist, i));
        }

        for(int j= k ; j< points.length; j++ ){
           int dist = (points[j][0] * points[j][0]) + (points[j][1] * points[j][1]);

           if(dist < maxheap.peek().distance){
            maxheap.poll();
            maxheap.offer(new Pair(dist, j));
           }
        }

        int [][] arr = new int[k][2];

        int m=0;
        while(!maxheap.isEmpty()){
            Pair current = maxheap.poll();

            arr[m] = points[current.index];
         
            m++;
        }

        return arr;

    }
}