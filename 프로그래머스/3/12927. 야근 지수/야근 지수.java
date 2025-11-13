import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long sum = 0;
        for (int w : works) sum += w;
        if (sum <= n) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) pq.add(w);

        while (n-- > 0) {
            int x = pq.poll();
            pq.add(x - 1);
        }

        long result = 0;
        for (int w : pq) result += (long) w * w;
        return result;
    }
}
