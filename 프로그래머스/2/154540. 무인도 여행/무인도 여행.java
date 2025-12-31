import java.util.*;

class Solution {
    int n, m;
    boolean[][] visited;
    String[] maps;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int[] solution(String[] maps) {
        this.maps = maps;
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    list.add(dfs(i, j));
                }
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    int dfs(int x, int y) {
        visited[x][y] = true;
        int sum = maps[x].charAt(y) - '0';

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }
            if (visited[nx][ny] || maps[nx].charAt(ny) == 'X') {
                continue;
            }

            sum += dfs(nx, ny);
        }

        return sum;
    }
}
