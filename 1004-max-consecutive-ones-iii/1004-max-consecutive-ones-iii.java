class Solution {
    public int longestOnes(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int i=0;
        int j=0;

        int maxfrequencyOne = 0;
        int maxlength = 0;

        while(j< nums.length){
            map.put(nums[j], map.getOrDefault(nums[j], 0) +1);

            maxfrequencyOne= Math.max(maxfrequencyOne, map.getOrDefault(1, 0));

            if((j-i+1) - maxfrequencyOne <= k){
                maxlength = Math.max(maxlength , j-i+1);
            }

            while( (j-i+1) - maxfrequencyOne > k){
                map.put(nums[i], map.get(nums[i]) -1);

                i++;
            }
            j++;
        }

        return maxlength;
    }
}