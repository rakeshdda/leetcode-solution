class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxlength =0;
        int i=0;
        int j=0;

        while(j< nums.length){
            map.put(nums[j], map.getOrDefault(nums[j], 0) +1);

            while(map.get(nums[j]) > k){
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);

                i++;
            }
            if(map.get(nums[j]) <= k){
                maxlength =Math.max(maxlength, j-i+1);
            }
            j++;
        }

        return maxlength;
    }
}