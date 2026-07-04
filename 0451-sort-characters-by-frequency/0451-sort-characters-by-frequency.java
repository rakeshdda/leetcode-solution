class Solution {
    class Pair{
        int freq;
        char ch;
    Pair(int freq, char ch){
        this.freq = freq;
        this.ch = ch;
    }
    }
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        PriorityQueue<Pair> maxheap = new PriorityQueue<>((a,b) -> {
            if(a.freq != b.freq){
                return b.freq- a.freq;
            }
            return a.ch - b.ch;
        });

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) +1);
        } 

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            maxheap.offer(new Pair(entry.getValue(), entry.getKey()));
        }

        StringBuilder sb = new StringBuilder();
        

        while(!maxheap.isEmpty()){
            Pair p = maxheap.poll();
            for(int i=0; i< p.freq; i++){
                sb.append(p.ch);
            }
        }
        String result = sb.toString();
        return result;
    }
}