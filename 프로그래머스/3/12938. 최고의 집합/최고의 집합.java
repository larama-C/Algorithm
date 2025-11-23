class Solution {
    public int[] solution(int n, int s) {
        int[] answer;

        if (s < n) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[n];
            int base = s / n;
            int r = s % n;

            for (int i = 0; i < n; i++) {
                answer[i] = base;
            }

            for (int i = n - 1; i >= n - r; i--) {
                answer[i] = answer[i] + 1;
            }
        }

        return answer;
    }
}
