import java.util.*;

class Solution {

    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        long maxsum = 0;
        long sum = 0;

        while (j < nums.length) {

            sum = sum + nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() < j - i + 1) {
                sum = sum - nums[i];

                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            if (j - i + 1 == k) {

                maxsum = Math.max(maxsum, sum);

                sum = sum - nums[i];

                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }

        return maxsum;
    }
}