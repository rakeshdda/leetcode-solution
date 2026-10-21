class Solution {
    public int trap(int[] height) {
        int n =height.length;

        int [] maxL =new int [n];
        int max =height[0];

        for(int i=0; i<n; i++){
            max=Math.max(max, height[i]);
            maxL[i] =max;
        }

        int [] maxR = new int[n];
        int maxInR =height[n-1];

        for(int i= n-1; i>=0; i--){
            maxInR = Math.max(maxInR, height[i]);
            maxR[i] = maxInR;
        }

        int [] min = new int[n];

        for(int i=0; i< n; i++){
            min[i] =Math.min(maxL[i], maxR[i]);
        }

        int waterBox =0;

        for(int i=0; i<n; i++){
            waterBox += (min[i] -height[i]);
        }
        return waterBox;
    }
}