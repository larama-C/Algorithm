class Solution {
    int n, m;
    int[][] land;
    int[][] group;
    int[] groupSize;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(int[][] land) {
        this.land = land;
        n = land.length;
        m = land[0].length;

        group = new int[n][m];
        groupSize = new int[n * m + 1];

        int id = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && group[i][j] == 0) {
                    groupSize[id] = dfs(i, j, id);
                    id++;
                }
            }
        }

        int answer = 0;

        for (int col = 0; col < m; col++) {
            boolean[] visited = new boolean[id];
            int sum = 0;

            for (int row = 0; row < n; row++) {
                int g = group[row][col];
                if (g > 0 && !visited[g]) {
                    visited[g] = true;
                    sum += groupSize[g];
                }
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }

    int dfs(int x, int y, int id) {
        group[x][y] = id;
        int count = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if (land[nx][ny] == 1 && group[nx][ny] == 0) {
                count += dfs(nx, ny, id);
            }
        }

        return count;
    }
}