import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        
        for (int x : queue1)
        { 
            q1.offer(x); sum1 += x;
        }
        for (int x : queue2)
        {
            q2.offer(x); sum2 += x;
        }

        long total = sum1 + sum2;
        if (total % 2 != 0)
        {
            return -1;
        }
        
        long target = total / 2;

        int limit = queue1.length * 3, cnt = 0;
        while (cnt <= limit)
        {
            if (sum1 == target)
            {
                return cnt;
            }
            if (sum1 > target)
            {
                int v = q1.poll();
                sum1 -= v;
                q2.offer(v);
            }
            else
            {
                int v = q2.poll();
                sum2 -= v;
                sum1 += v;
                q1.offer(v);
            }
            cnt++;
        }
        return -1;
    }
}