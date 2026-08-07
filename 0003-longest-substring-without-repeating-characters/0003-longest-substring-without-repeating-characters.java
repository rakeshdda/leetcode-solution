class Solution {
    public int lengthOfLongestSubstring(String s) {
       int i=0;
       int j=0;
       int maxlength=0;

       HashMap<Character, Integer> map = new HashMap<>();
       while(j< s.length()){
        map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

        if(map.size() == j-i+1){
            maxlength =  Math.max(maxlength, j-i+1);
            j++;
        }else if(map.size() < j-i+1){
            while(map.size() < j-i+1){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if(map.get(s.charAt(i)) ==0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }
       }
       return maxlength;
       
       
        // HashSet<Character> set = new HashSet<>();
        // int i=0;
        // int j=0;
        // int n= s.length();
        // int max=0;

        // while(j< n){
        //     char ch= s.charAt(j);

        //     if(!set.contains(ch)){
        //         set.add(ch);
        //         max= Math.max(max, j-i+1);
        //         j++;
        //     }else{
        //         set.remove(s.charAt(i));
        //         i++;
                
        //     }
        // }
        // return max;
    }
}