class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0;
        int j = 0;

        int minlength = Integer.MAX_VALUE;
        String ans = "";

        while (j < s.length()) {
            char ch = s.charAt(j);

            if (ch == '1') {
                k--;
            }

            while (k == 0) {

                String current = s.substring(i, j+1);

                if (minlength > j - i + 1 || j - i + 1 == minlength && current.compareTo(ans) < 0) {

                    minlength = j - i + 1;
                    ans = current;
                }

                if (s.charAt(i) == '1') {
                    k++;
                }
                i++;
            }
            j++;
        }

        return ans;
    }
}