class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int INF = 200000000;
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int[] fare : fares) {
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];

            dist[c][d] = f;
            dist[d][c] = f;
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (dist[start][end] > dist[start][mid] + dist[mid][end]) {
                        dist[start][end] = dist[start][mid] + dist[mid][end];
                    }
                }
            }
        }

        int answer = INF;

        for (int k = 1; k <= n; k++) {
            int cost = dist[s][k] + dist[k][a] + dist[k][b];
            answer = Math.min(answer, cost);
        }

        return answer;
    }
}