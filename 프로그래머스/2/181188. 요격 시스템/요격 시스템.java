class Solution {
    public int solution(int[][] targets) {

        int n = targets.length;
        int max = 100000000;

        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[targets[i][1]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[][] sorted = new int[n][2];
        for (int i = n - 1; i >= 0; i--) {
            int e = targets[i][1];
            int idx = --count[e];
            sorted[idx][0] = targets[i][0];
            sorted[idx][1] = e;
        }

        int result = 0;
        int last = -1;

        for (int i = 0; i < n; i++) {
            if (last <= sorted[i][0]) {
                result++;
                last = sorted[i][1];
            }
        }

        return result;
    }
}
