class Solution {

    public int largestRectangleArea(int[] heights) {
        int n= heights.length;

        int [] nsl = nearestSmallerLeft(heights);

        int [] nsr = nearestSmallerRight(heights);

        int [] width = new int[n];

        for(int i =0; i< n; i++){
            width[i] = nsr[i] -nsl[i] -1;
        }

        int max =Integer.MIN_VALUE;

        for(int i=0; i< n; i++){
            max =Math.max(max, width[i]* heights[i]);
        }
        return max;
    }
    class Pair{
        int index;
        int val;
    Pair(int index, int val){
        this.index = index; 
        this.val = val;
    }
    }
    public int[] nearestSmallerLeft(int [] heights){
        Stack<Pair> stack = new Stack();
        
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i< heights.length; i++){
            while(!stack.isEmpty() && stack.peek().val >= heights[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                list.add(-1);
            }else{
                list.add(stack.peek().index);
            }

            stack.push(new Pair(i,heights[i]));
        }
        int[] ans  = new int[heights.length];

        for(int i=0; i< heights.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }


    public int [] nearestSmallerRight(int [] heights){
        Stack<Pair> stack = new Stack();

        ArrayList<Integer> list= new ArrayList<>();

        for(int i=heights.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek().val >= heights[i] ){
                stack.pop();
            }

            if(stack.isEmpty()){
                list.add(heights.length);
            }else{
                list.add(stack.peek().index);
            }

            stack.push(new Pair(i,heights[i]));
        }

        Collections.reverse(list);

        int[] ans = new int[heights.length];

        for(int i=0; i< heights.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}