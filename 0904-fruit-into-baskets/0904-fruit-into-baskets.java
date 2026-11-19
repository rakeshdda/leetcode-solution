class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int i=0;
        int j=0;
        int maxCount =0;


        while(j< fruits.length){
            map.put (fruits[j], map.getOrDefault(fruits[j], 0) +1);

          
            if(map.size() > 2){
                while(map.containsKey(fruits[i])){
                    map.put(fruits[i], map.get(fruits[i])-1);

                    if(map.get(fruits[i]) == 0){
                        map.remove(fruits[i]);
                    }
                }
                i++;
            }

            maxCount =Math.max(maxCount, j-i+1);
            j++;
        }

        return maxCount;
    }
}