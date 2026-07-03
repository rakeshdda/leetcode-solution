class Solution {
    class Pair {
        int freq;
        int ele;

        Pair(int freq, int ele) {
            this.freq = freq;
            this.ele = ele;

        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> minheap = new PriorityQueue<>((a, b) -> a.freq - b.freq);

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

       
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (minheap.size() < k) {
                minheap.offer(new Pair(entry.getValue(), entry.getKey()));
                
            } else {
                if (minheap.peek().freq < entry.getValue()) {
                    minheap.poll();
                    minheap.offer(new Pair(entry.getValue(), entry.getKey()));
                }
            }
        }

        int[] arr = new int[k];
        int j = 0;

        while (!minheap.isEmpty()) {

            arr[j]= minheap.peek().ele;
            minheap.poll();
            j++;
        }
        return arr;
    }
}