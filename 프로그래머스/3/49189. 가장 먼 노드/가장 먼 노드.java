import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : g.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }

        int max = 0;
        
        for (int d : dist) {
            if (d > max) { 
                max = d;
            }
        }
        
        for (int d : dist) {
            if (d == max) { 
                answer++;
            }
        }

        return answer;
    }
}