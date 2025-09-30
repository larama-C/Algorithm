import java.util.*;

public class Solution {
    public int solution(int N, int[][] road, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int i = 1; i <= N; i++) 
        {
            graph.put(i, new ArrayList<>());
        }

        for (int[] r : road) 
        {
            int a = r[0], b = r[1], c = r[2];
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int i = 1; i < N; i++) 
        {
            for (int cur = 1; cur <= N; cur++) 
            {
                if (dist[cur] == Integer.MAX_VALUE)
                {
                    continue;
                }
                
                for (int[] next : graph.get(cur)) 
                {
                    int nxt = next[0];
                    int cost = next[1];
                    if (dist[nxt] > dist[cur] + cost) 
                    {
                        dist[nxt] = dist[cur] + cost;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) 
        {
            if (dist[i] <= K) count++;
        }
        
        return count;
    }
}