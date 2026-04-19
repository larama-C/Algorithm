import java.util.*;

class Solution {
    int n, m;
    char[][] map;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();

        map = new char[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(map[i], '.');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        for (String req : requests) {
            char target = req.charAt(0);

            if (req.length() == 2) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (map[i][j] == target) {
                            map[i][j] = '.';
                        }
                    }
                }
            } else {
                boolean[][] visited = new boolean[n + 2][m + 2];
                Queue<int[]> q = new LinkedList<>();

                q.offer(new int[]{0, 0});
                visited[0][0] = true;

                List<int[]> removeList = new ArrayList<>();

                while (!q.isEmpty()) {
                    int[] cur = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];

                        if (nx < 0 || ny < 0 || nx >= n + 2 || ny >= m + 2) continue;
                        if (visited[nx][ny]) continue;

                        if (map[nx][ny] == '.') {
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                        else if (map[nx][ny] == target) {
                            visited[nx][ny] = true;
                            removeList.add(new int[]{nx, ny});
                        }
                    }
                }

                for (int[] r : removeList) {
                    map[r[0]][r[1]] = '.';
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != '.') answer++;
            }
        }

        return answer;
    }
}