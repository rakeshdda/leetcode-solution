class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] prev = new int[cols];

        for (int i = 0; i < cols; i++) {
            prev[i] = matrix[0][i]- '0';
        }

        int max = MAH(prev);

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '0') {
                    prev[j] = 0;
                } else {
                    prev[j] += 1;
                }
            }
            max = Math.max(max, MAH(prev));
        }

        return max;
    }
    public int MAH(int [] arr){
         int [] nsr = NSR(arr);
         int [] nsl = NSL(arr);

        int[] width = new int[arr.length];

        for(int i =0; i< arr.length; i++){
            width[i] = nsr[i] -nsl[i] -1;
        }

        for(int i=0; i< width.length; i++){
            width[i] = width[i] * arr[i];
        }

        int maxArea = 0;

        for(int i =0; i< width.length; i++){
            maxArea = Math.max(maxArea, width[i]);
        }
        return maxArea;
    }
    class Pair{
        int val; 
        int index;
    Pair(int val, int index){
        this.val = val;
        this.index =index;
    }
    }
    public int[] NSR(int[] arr){
        Stack<Pair> stack = new Stack();
        ArrayList<Integer> list = new ArrayList<>();


        for(int i=arr.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek().val >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                list.add(arr.length);
            }else{
                list.add(stack.peek().index);
            }
            stack.push(new Pair(arr[i], i));
        }

        Collections.reverse(list);
        
        int [] ans = new int[list.size()];

        for(int i=0; i< list.size(); i++){
            ans[i] = list.get(i);
        }

        return ans;
    }

    public int [] NSL(int[] arr){
        Stack<Pair> stack = new Stack();
        ArrayList<Integer> list = new ArrayList<>();


        for(int i =0; i< arr.length; i++){
            while(!stack.isEmpty() && stack.peek().val >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                list.add(-1);
            }else{
                list.add(stack.peek().index);
            }
            stack.push(new Pair(arr[i], i));
        }

        int[] ans = new int[list.size()];

        for(int i =0; i< list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}