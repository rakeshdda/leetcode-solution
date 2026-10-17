class Solution {
    class Pair{
        int val;
        int index;
    Pair(int val, int index){
        this.val = val;
        this.index = index;
    }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Pair> stack = new Stack();

        for(int i= temperatures.length-1; i>=0; i--){

            while(!stack.isEmpty() && stack.peek().val <= temperatures[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                list.add(0);
            }else{
                list.add(stack.peek().index - i);
            }
            stack.push(new Pair(temperatures[i], i));
        }

        Collections.reverse(list);

        int[] ans = new int[list.size()];
        for(int i=0; i< list.size(); i++){
            ans[i] =list.get(i);
        }

        return ans;
    }
}