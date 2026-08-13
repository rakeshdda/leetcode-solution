class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int atMostGoal = atMost(nums, goal);
        int atMostGoalMinusOne = atMost(nums, goal - 1);

        int exactlyGoal = atMostGoal - atMostGoalMinusOne;

        return exactlyGoal;

        // HashMap<Integer, Integer> map = new HashMap<>();
        // int count = 0;
        // int sum = 0;

        // map.put(0, 1);

        // for (int i = 0; i < nums.length; i++) {
        //     sum += nums[i];

        //     if (map.containsKey(sum - goal)) {
        //         count += map.get(sum - goal);
        //     }

        //     map.put(sum, map.getOrDefault(sum, 0) + 1);

        // }

        // return count;

    }

    public int atMost(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int count = 0;
        int sum = 0;

        while (j < nums.length) {
            sum += nums[j];

            while (sum > k) {
                sum = sum - nums[i];
                i++;
            }

            count += j - i + 1;

            j++;
        }

        return count;
    }
}