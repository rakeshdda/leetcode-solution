class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int maxlength =0;

        int i=0;
        int j=0;

        while(j< s.length()){
            char ch = s.charAt(j);

            map.put(ch, map.getOrDefault(ch, 0) +1);

            if(map.get(ch) >1){
                while(map.size() != j-i+1){

                    map.put(s.charAt(i), map.get(s.charAt(i)) -1);

                    if(map.get(s.charAt(i)) == 0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }

            maxlength =Math.max(maxlength, j-i+1);

            j++;
        }

        return maxlength;
    }
}