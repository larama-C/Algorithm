import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        List<List<Integer>> g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int[] r : roads) {
            g.get(r[0]).add(r[1]);
            g.get(r[1]).add(r[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(destination);
        dist[destination] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int nd = dist[cur] + 1;
            for (int nxt : g.get(cur)) {
                if (dist[nxt] == -1) {
                    dist[nxt] = nd;
                    q.add(nxt);
                }
            }
        }
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}