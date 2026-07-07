class Solution {
    public long sumAndMultiply(int n) {
        long x=0;
        long sum =0;

        while(n> 0){
            int digit = n%10;

            if(digit !=0){
            x = x*10 + digit;
         
            }

            sum += digit;

            n = n/10;
        }

        long y =0;
        while(x>0){
            long newdigit= x % 10;

            y = y*10 + newdigit;
            x= x/10;
        }

        return sum * y;

    }
}