class Solution {
    public void moveZeroes(int[] nums) {
        
      
        // int insertPosition =0;
        // for(int i =0;i<nums.length;i++){
        //     if(nums[i]!=0){
        //         nums[insertPosition]= nums[i];
        //         insertPosition++;
        //     }
        // }
        // while(insertPosition <nums.length){
        //     nums[insertPosition] =0;
        //     insertPosition++;
        // }

        //use two pinter

        int i=0;
        int j=0;

        while(j< nums.length){
            // if(nums[i] != 0){
            //     i++;
            // }
            if(nums[j] !=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] =temp;
                
                i++;
            }
            j++;
        }

   
    }
}
    