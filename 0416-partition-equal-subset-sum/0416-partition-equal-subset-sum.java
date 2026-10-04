class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        Boolean[][] t = new Boolean[n + 1][target + 1];

        return canWe(nums, target, n, t);
    }

    public boolean canWe(int[] arr, int target, int n, Boolean[][] t) {
        if (target == 0) {
            return true;
        }
        if(n == 0){
            return false;
        }

        if (t[n][target] != null) {
            return t[n][target];
        }
        if (arr[n - 1] <= target) {
            return t[n][target] = canWe(arr, target - arr[n - 1], n - 1, t) || canWe(arr, target, n - 1, t);
        } else {
            return t[n][target] = canWe(arr, target, n - 1, t);
        }
    }
}