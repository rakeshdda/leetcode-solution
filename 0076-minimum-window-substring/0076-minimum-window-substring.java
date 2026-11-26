class Solution {
    public String minWindow(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();

    for(int k=0; k< t.length(); k++){
        map.put(t.charAt(k), map.getOrDefault(t.charAt(k), 0) +1);
    }

    int i=0;
    int j =0;
    String result ="";

    int count =map.size();
    int minlength =Integer.MAX_VALUE;

    while(j< s.length()){
        char ch = s.charAt(j);
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch) -1);

            if( map.get(ch) == 0){
                count--;
            }
        }

        while(count == 0){
            if(minlength > j-i+1 ){
                minlength =j-i+1;
                
                result =s.substring(i, j+1);
            }

            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);

                if(map.get(s.charAt(i)) == 1){
                    count++;
                }
            }
            i++;
        }
        j++;
    }

    return result;

    }
}