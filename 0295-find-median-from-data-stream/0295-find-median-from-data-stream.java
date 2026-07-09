class MedianFinder {
    PriorityQueue<Integer> leftmaxheap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightminheap = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(leftmaxheap.isEmpty() || num < leftmaxheap.peek()){
            leftmaxheap.offer(num);
        }else{
            rightminheap.offer(num);
        }


        if(leftmaxheap.size() - rightminheap.size() > 1){
            rightminheap.offer(leftmaxheap.poll());
        }
        else if(rightminheap.size() >  leftmaxheap.size()){
            leftmaxheap.offer(rightminheap.poll());
        }
    }
    
    public double findMedian() {
        if(leftmaxheap.size() == rightminheap.size()){
            double mean = (double)(leftmaxheap.peek() + rightminheap.peek())/2;
            return mean;
        }else{
            return leftmaxheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */