class Solution {

    public int largestRectangleArea(int[] heights) {

        ArrayList<Integer> nsr = findNSR(heights);
        ArrayList<Integer> nsl = findNSL(heights);

        int[] width = new int[heights.length];

        for(int i=0; i< heights.length; i++){
            width[i] = nsr.get(i) - nsl.get(i) -1;
        }

        //for area
        for(int i=0; i< heights.length; i++){
            width[i] = heights[i] * width[i];
        }

        int max=  Integer.MIN_VALUE;
        for(int i=0; i< width.length; i++){
            if(width[i] > max){
                max= width[i];
            }
        }
        return max;
    }

    
    class Pair {
        int key;
        int val;

        Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    //for find nsr
    public ArrayList<Integer> findNSR(int[] arr) {

        ArrayList<Integer> list1 = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().val >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                list1.add(arr.length);
            } else if (!stack.isEmpty() && stack.peek().val < arr[i]) {
                list1.add(stack.peek().key);
            }

            stack.push(new Pair(i, arr[i]));
        }
        Collections.reverse(list1);
        return list1;
    }


    //for finding nsl
    public ArrayList<Integer> findNSL(int[] arr) {
        ArrayList<Integer> list2 = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i< arr.length; i++) {
            while (!stack.isEmpty() && stack.peek().val >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                list2.add(-1);
            } else if (!stack.isEmpty() && stack.peek().val < arr[i]) {
                list2.add(stack.peek().key);
            }

            stack.push(new Pair(i, arr[i]));
        } 
        return list2;
    }

}