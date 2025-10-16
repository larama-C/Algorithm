import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = n;

        for (int i = 0; i < wires.length; i++) {
            graph = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) graph[j] = new ArrayList<>();

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int a = wires[j][0], b = wires[j][1];
                graph[a].add(b);
                graph[b].add(a);
            }

            visited = new boolean[n + 1];
            int count = dfs(1);
            answer = Math.min(answer, Math.abs(n - 2 * count));
        }

        return answer;
    }

    private int dfs(int node) {
        visited[node] = true;
        int cnt = 1;
        for (int next : graph[node]) {
            if (!visited[next]) {
                cnt += dfs(next);
            }
        }
        return cnt;
    }
}