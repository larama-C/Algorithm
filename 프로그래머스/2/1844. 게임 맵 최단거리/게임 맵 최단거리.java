import java.util.*;

class Solution {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) 
        {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) 
            {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int answer = maps[n-1][m-1];
        
        return (answer == 1) ? -1 : answer;
    }
}
