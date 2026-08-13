class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int atMostKodd = helper(nums, k);
        int atMostKminusOneodd= helper(nums, k-1);

        int exactlyKodd= atMostKodd- atMostKminusOneodd;

        return exactlyKodd;
    }
    public int helper(int[] nums, int k){
        int i=0;
        int j=0;
        
        int oddcount =0;
        int subarraycount =0;

        while(j< nums.length){
            if(nums[j] % 2 != 0){
                oddcount++;
            }

            while(oddcount > k){
                if(nums[i] % 2 != 0){
                    oddcount--;
                }
                i++;
            }

            subarraycount += j-i+1;

            j++;
        }
        return subarraycount;
    }
}