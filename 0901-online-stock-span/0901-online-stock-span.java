class StockSpanner {
    class Pair{
        int value;
        int span;
    Pair(int value, int span){
        this.value = value;
        this.span = span;
    }
    }


    Stack<Pair> stack = new Stack<>();

    // public StockSpanner() {
        
    // }
    
    public int next(int price) {
        int span =1;

        while(!stack.isEmpty() && stack.peek().value <= price){
            span += stack.pop().span;
        }

        stack.push(new Pair(price, span));

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */