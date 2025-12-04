class Solution {
    public int solution(int N, int[] stations, int W) {
        int answer = 0;
        int cover = (2 * W) + 1;
        int prev = 0;

        for (int s : stations) {
            int gap = (s - W - 1) - prev;
            if (gap > 0) {
                answer += (gap + cover - 1) / cover;
            }
            prev = s + W;
        }

        if (prev < N) {
            answer += (N - prev + cover - 1) / cover;
        }

        return answer;
    }
}