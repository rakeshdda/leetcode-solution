class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int atMostK = findAtMost(nums, k);
        int atMostKminusOne= findAtMost(nums, k-1);

        int exactlyK= atMostK - atMostKminusOne;

        return exactlyK; 
    }
    public int findAtMost(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        int i =0;
        int j=0;
        int count =0;

        while(j< nums.length){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while(map.size() > k){
                map.put(nums[i], map.getOrDefault(nums[i], 0) -1);
                
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }

            if(map.size() <= k){
                count = count + (j-i+1);
            }
            j++;
        }
        return count;
    }

}