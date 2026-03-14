import java.util.*;

class Solution {
    public int solution(int[][] scores) {

        int a = scores[0][0];
        int b = scores[0][1];
        int sum = a + b;

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });

        int max = 0;
        int rank = 1;

        for (int[] s : scores) {

            int x = s[0];
            int y = s[1];

            if (y < max) {
                if (x == a && y == b) return -1;
                continue;
            }

            max = Math.max(max, y);

            if (x + y > sum) {
                rank++;
            }
        }

        return rank;
    }
}