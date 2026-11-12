class Solution {
    class Pair{
        int dist;
        int ele;
    Pair(int dist, int ele){
        this.dist = dist;
        this.ele = ele;
    }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> maxheap = new PriorityQueue<>((a,b) -> b.dist-a.dist);

        List<Integer> list = new ArrayList<>();

        for(int i=0; i< k; i++){
            int calculatedDistance =Math.abs(arr[i]-x);
            maxheap.offer(new Pair(calculatedDistance, arr[i]));
        }

        for(int i=k; i< arr.length; i++){

            int calculatedDistance =Math.abs(arr[i]-x);

            if(maxheap.peek().dist > calculatedDistance){
                maxheap.poll();
                maxheap.offer(new Pair(calculatedDistance, arr[i]));
            }
            else if(maxheap.peek().dist == calculatedDistance){
                if(maxheap.peek().ele > arr[i]){
                    maxheap.poll();
                    maxheap.offer(new Pair(calculatedDistance, arr[i]));
                }
            }
        }

        while(!maxheap.isEmpty()){
            list.add(0, maxheap.poll().ele);
        }
        Collections.sort(list);
        return list;
    }
}