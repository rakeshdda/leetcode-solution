class Solution {
    class Pair {
        int freq;
        int ele;

        Pair(int freq, int ele) {
            this.freq = freq;
            this.ele = ele;
        }
    }

    public int[] frequencySort(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> minheap = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) {
                return a.freq - b.freq;
            }
            return b.ele - a.ele;
        });

        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minheap.offer(new Pair(entry.getValue(), entry.getKey()));
        }

        int[] ans = new int[nums.length];
        int i = 0;

        while (!minheap.isEmpty()) {
            Pair p = minheap.poll();
            for (int j = 0; j < p.freq; j++) {
                ans[i] = p.ele;
                i++;
            }
        }
        return ans;

    }
}