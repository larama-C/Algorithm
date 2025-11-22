import java.util.*;

class Solution
{
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(String[] maps)
    {
        int n = maps.length, m = maps[0].length();
        int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);

                if (c == 'S') {
                    sx = i;
                    sy = j;
                }
                else if (c == 'L') {
                    lx = i;
                    ly = j;
                }
                else if (c == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }

        int a = bfs(maps, sx, sy, lx, ly);
        if (a == -1) return -1;

        int b = bfs(maps, lx, ly, ex, ey);
        if (b == -1) return -1;

        return a + b;
    }

    int bfs(String[] maps, int sx, int sy, int tx, int ty) {
        int n = maps.length, m = maps[0].length();
        boolean[][] v = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sx, sy, 0});
        v[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] c = q.poll();

            if (c[0] == tx && c[1] == ty) {
                return c[2];
            }

            for (int k = 0; k < 4; k++)
            {
                int nx = c[0] + dx[k];
                int ny = c[1] + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (v[nx][ny] || maps[nx].charAt(ny) == 'X') {
                    continue;
                }

                v[nx][ny] = true;
                q.add(new int[]{nx, ny, c[2] + 1});
            }
        }

        return -1;
    }
}