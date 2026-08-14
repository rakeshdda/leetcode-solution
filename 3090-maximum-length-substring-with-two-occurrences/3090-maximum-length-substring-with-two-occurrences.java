class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int i=0;
        int j=0;
        int maxlength =0;

        while(j< s.length()){
            char ch =s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.get(ch) > 2){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)- 1);
                i++;
            }

            maxlength = Math.max(maxlength, j-i+1);
            
            j++;
        }
        return maxlength;
    }
}