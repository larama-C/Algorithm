import java.util.*;

class Solution {
    public int solution(String[] board) {

        int n = board.length;
        int m = board[0].length();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[][][] next = new int[n][m][2];

        int sx = 0, sy = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    sx = i;
                    sy = j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i].charAt(j) == 'D') continue;

                for (int d = 0; d < 4; d++) {

                    int nx = i;
                    int ny = j;

                    while (true) {
                        int tx = nx + dx[d];
                        int ty = ny + dy[d];

                        if (tx < 0 || ty < 0 || tx >= n || ty >= m) {
                            break;
                        }
                        if (board[tx].charAt(ty) == 'D') {
                            break;
                        }

                        nx = tx;
                        ny = ty;
                    }

                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            if (board[x].charAt(y) == 'G') {
                return cnt;
            }

            for (int d = 0; d < 4; d++) {

                int nx = x;
                int ny = y;

                while (true) {
                    int tx = nx + dx[d];
                    int ty = ny + dy[d];

                    if (tx < 0 || ty < 0 || tx >= n || ty >= m) {
                        break;
                    }
                    if (board[tx].charAt(ty) == 'D') {
                        break;
                    }

                    nx = tx;
                    ny = ty;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        return -1;
    }
}