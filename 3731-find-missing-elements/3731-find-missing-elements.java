class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            min= Math.min(min, num);
            max= Math.max(max, num);
        }

        for(int num: nums){
            set.add(num);
        }

        for(int i = min+1; i< max; i++){
            if(!set.contains(i)){
                list.add(i);
            }
         }
   return list;


    //     List<Integer> list = new ArrayList<>();

    //    Arrays.sort(nums);

    //    int start =nums[0];
    //    int end  = nums[nums.length-1];

    //    for(int i =start; i<= end; i++){
    //     if(!find(nums, i)){
    //         list.add(i);
    //     }
    //    }
    //    return list;
    // }
    // public boolean find(int[] arr, int target){
    //     for(int i=0; i< arr.length;i++){
    //         if(arr[i] == target){
    //             return true;
    //         }
    //     }
    //     return false;
    }
}