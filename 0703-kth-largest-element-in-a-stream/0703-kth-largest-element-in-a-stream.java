class KthLargest {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int K;
    public KthLargest(int k, int[] nums) {
        K=k;
        for(int num: nums){
            minheap.offer(num);

            if(minheap.size() > K){
                minheap.poll();
            }
        }
    }
    
    public int add(int val) {
        minheap.offer(val);

        if(minheap.size() > K){
            minheap.poll();
        }

        return minheap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */