class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();

       Arrays.sort(nums);

       int start =nums[0];
       int end  = nums[nums.length-1];

       for(int i =start; i<= end; i++){
        if(!find(nums, i)){
            list.add(i);
        }
       }
       return list;
    }
    public boolean find(int[] arr, int target){
        for(int i=0; i< arr.length;i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }
}