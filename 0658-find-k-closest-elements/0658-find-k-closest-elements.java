class Solution {
    class Pair {
        int value;
        int key;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Pair> maxheap = new PriorityQueue<>((a, b) -> b.key - a.key);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {

            int no = Math.abs(arr[i] - x);
            //inserted key, value
            maxheap.offer(new Pair(no, arr[i]));
        }

        int j = k;
        while (j < arr.length) {

            int no1 =Math.abs(arr[j] - x);
            
            if ( no1 < maxheap.peek().key) {
                maxheap.poll();
                maxheap.offer(new Pair(no1, arr[j]));
            }
            j++;
        }

        while (!maxheap.isEmpty()) {
            Pair p = maxheap.poll();
            ans.add(0, p.value);
        }

        Collections.sort(ans);

        return ans;
    }
}