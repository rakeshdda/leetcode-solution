class Solution {
    public int findKthLargest(int[] nums, int k) {
    //     return quickSort(nums, 0, nums.length-1,nums.length-k);
    // }
    // public static int quickSort(int[] nums, int low, int high,int k) {
    //    if (low <= high) {
           
        
    //     int s = low;
    //     int e = high;

    //     int n= nums.length;
    //     int m = s + (e - s) / 2;

    //     int pivot = nums[m];

    //     while (s <= e) {
    //         while (nums[s] < pivot) {
    //             s++;
    //         }
    //         while (nums[e] > pivot) {
    //             e--;
    //         }

    //         if (s <= e) {
    //             // swap
    //             int temp = nums[s];
    //             nums[s] = nums[e];
    //             nums[e] = temp;
    //             s++;
    //             e--;
    //         }
    //         }
        
        
    //    if(k<=e){
    //     return quickSort(nums, low, e, k);
    //    }
    //    else if(k>=s){
    //     return quickSort(nums, s, high, k);
    //    }else{
    //    return nums[k];
    //    }
    // }
    // return -1;

    PriorityQueue<Integer> minheap = new PriorityQueue<>();

    for(int i =0 ;i<k; i++){
        minheap.offer(nums[i]);
    }


      for(int i=k; i< nums.length; i++){
        if(nums[i] > minheap.peek()){
            minheap.poll();
            minheap.offer(nums[i]);
        }
      }

      return minheap.peek();
     }
}

