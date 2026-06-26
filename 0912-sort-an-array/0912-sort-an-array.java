class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(nums, i, 0);

            heapify(nums, i, 0);
        }
        return nums;
    }
    // public void heapify(int[] arr, int n, int i){
    //     int largest =i;
    //     int left = 2*i +1;
    //     int right = 2*i +2;

    //     if(left <n && arr[left] > arr[largest]){
    //         largest = left;
    //     }
    //     if(right < n && arr[right] > arr[largest]){
    //         largest = right;
    //     }
    //     if(largest != i){
    //         swap(arr, largest, i);

    //         heapify(arr, n, largest);
    //     }
    // }

   void heapify(int[] arr, int n, int i) {

        while (true) {

            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest == i) {
                break; // Heap property restored
            }

            swap(arr, i, largest);

            i = largest; // Continue heapifying from the child
        }
    }

    public void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}