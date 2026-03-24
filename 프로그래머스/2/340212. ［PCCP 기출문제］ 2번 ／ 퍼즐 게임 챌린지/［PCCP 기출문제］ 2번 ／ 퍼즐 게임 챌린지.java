class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (Solve(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean Solve(int[] diffs, int[] times, long limit, int level) {
        long total = times[0];

        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                total += times[i];
            } else {
                long fail = diffs[i] - level;
                total += (long) (times[i] + times[i - 1]) * fail + times[i];
            }

            if (total > limit) {
                return false;
            }
        }

        return total <= limit;
    }
}