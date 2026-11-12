class Solution {
    public int[] sortArray(int[] nums) {
        int n= nums.length;

        for(int i=n/2-1; i>=0 ; i--){
            heapify(i, n, nums);
        }
    
        for(int i=n-1 ; i>0;  i--){
            swap(0, i, nums);

            heapify(0, i, nums);
        }

        return nums;
    }
    public void heapify(int i, int n, int[] nums){
        int largest =i;
        int left =2*i +1;
        int right =2*i +2;

        if(left < n && nums[left] > nums[largest]){
            largest =left;
        }
        if(right < n && nums[right] > nums[largest]){
            largest =right;
        }
        if(largest != i){
            swap(largest, i, nums);

            heapify(largest, n, nums);
        }
    }
    public void swap(int first, int second, int[] nums){
        int temp= nums[first];
        nums[first] = nums[second];
        nums[second]= temp;     
    }
}