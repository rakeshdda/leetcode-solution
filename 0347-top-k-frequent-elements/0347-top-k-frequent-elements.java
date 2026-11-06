class Solution {
    class Pair {
        int freq;
        int val;
    Pair(int freq, int val){
        this.freq = freq;
        this.val = val;
    }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> minheap = new PriorityQueue<>((a,b) -> a.freq-b.freq);

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(minheap.size() <k){
                minheap.offer(new Pair(entry.getValue(), entry.getKey()));
            }
            else if(minheap.peek().freq < entry.getValue()){
                minheap.poll();
                minheap.offer(new Pair(entry.getValue(), entry.getKey()));
            }
        }

        int[] ans= new int[k];
        int j=0;

        while(!minheap.isEmpty()){
            ans[j] = minheap.poll().val;
            j++;
        }

        return ans;

    }
}