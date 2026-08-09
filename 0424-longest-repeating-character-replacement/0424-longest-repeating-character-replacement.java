class Solution {
    public int characterReplacement(String s, int k) {

    //    its a game of window size and k, check if windowSize - maxfrequency <= k, thatmeans that window is valid to replace character, because window size = total character, if we remove maxfrequency(most frequent character), we will get the no. of charcter that is to be replaced let say x , when x <= k means , you can replace those with other char, if x= 2 ,k =3 that means in that window you can replace element 3 times, and x =2 so thats a valid window

        HashMap<Character, Integer> map = new HashMap<>();
        
        int i=0;
        int j =0;
        
        int maxlength =0;
        int maxfrequency =0;

        while(j< s.length()){
            
            char ch = s.charAt(j);

            map.put(ch, map.getOrDefault(ch, 0) +1);

            maxfrequency =Math.max(maxfrequency, map.get(ch));

            //window is valid
            if( (j-i +1) - maxfrequency <= k){
                maxlength = Math.max(maxlength , j-i+1);
            }

            //window is not valid
            while((j-i +1) - maxfrequency >  k ){
                
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

                    
                    i++;   
            }

            j++;
        }
        return maxlength;
    }
}