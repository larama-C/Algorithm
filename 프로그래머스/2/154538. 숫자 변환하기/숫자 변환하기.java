import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> check = new HashSet<>();

        q.add(new int[]{x, 0});
        check.add(x);

        while (!q.isEmpty()) 
        {
            int[] cur = q.poll();
            int num = cur[0];
            int cnt = cur[1];
            
            if (num == y) 
            {
                return cnt;
            }
            
            int[] arr = {num + n, num * 2, num * 3};
            
            for (int a : arr) 
            {
                if (a <= y && !check.contains(a)) 
                {
                    q.add(new int[]{a, cnt + 1});
                    check.add(a);
                }
            }
        }
        
        return -1;
    }
}