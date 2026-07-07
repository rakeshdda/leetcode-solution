/*the question is asking for k points , which are at minimum distance from the origin(0,0)

so what do we need to store in the heap; 
first we need a max heap, bcz we nees the k minimum distance points, so maxheap;
second what i store in heap, definately distance ,which will dicide which point will be at the top or bottom of heap; else what? the index of that point, let say if i need to store (3,3)'s then  store(undertoot of (9), index of 3,3 int the given array;

but taking square root for distance will make the code more complex ,so just take square, for (3,3) , take only 9 , not square root of (9).  thats it , */

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