class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();
		
		for(int i =0; i< num.length(); i++){
			char ch =num.charAt(i);
			
			while(!stack.isEmpty() && ch < stack.peek() && k>0){
				stack.pop();
				k--;
			}
			stack.push(ch);
		}
		
		while(k>0){
			stack.pop();
			k--;
		}		
		
		StringBuilder sb = new StringBuilder();
		
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		
		sb.reverse();
		
		String ans = sb.toString().replaceFirst("^0+","");
		
		if(ans.isEmpty()){
			return "0";
		}
		
		return ans;

    }
}