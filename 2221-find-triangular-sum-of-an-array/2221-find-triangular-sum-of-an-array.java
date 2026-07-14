class Solution {
    public int triangularSum(int[] nums) {
        if(nums.length == 1){
        	return nums[0];
        }
        
        int[] temp = new int[nums.length-1];
        
        for(int i =0; i < nums.length-1; i++){
        	int x = nums[i] + nums[i+1];
        	
        	temp[i] = x%10;
        }
        
        return triangularSum(temp);
    }
}