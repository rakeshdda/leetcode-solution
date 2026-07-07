class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();

        int i= left;
        while(i <= right){

            if(i % 10 !=0){
                if(check(i, i)){
                    list.add(i);
                }
            }
            i++;
        }
        return list;
    }

    public boolean check(int n, int x){
        if(x == 0){
            return true;
        }

        int digit = x % 10;

        if(digit == 0){
            return false;
        }
        if(n % digit != 0){
            return false;
        }

        x= x/10;

        return check(n, x);
    }
}