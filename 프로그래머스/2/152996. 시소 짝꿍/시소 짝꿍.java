class Solution {
    public long solution(int[] weights) {
        long[] cnt = new long[1001];

        for (int w : weights) {
            cnt[w]++;
        }

        long answer = 0;

        for (int w = 100; w <= 1000; w++) {
            if (cnt[w] >= 2) {
                answer += cnt[w] * (cnt[w] - 1) / 2;
            }
        }

        for (int w = 100; w <= 1000; w++) {
            if (cnt[w] == 0) {
                continue;
            }

            if (w * 3 % 2 == 0) {
                int t = w * 3 / 2;
                if (t <= 1000) {
                    answer += cnt[w] * cnt[t];
                }
            }

            if (w * 2 <= 1000) {
                answer += cnt[w] * cnt[w * 2];
            }

            if (w * 4 % 3 == 0) {
                int t = w * 4 / 3;
                if (t <= 1000) {
                    answer += cnt[w] * cnt[t];
                }
            }
        }

        return answer;
    }
}
