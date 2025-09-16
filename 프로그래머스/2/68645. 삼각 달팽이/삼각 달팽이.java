import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][];
        
        for (int i = 0; i < n; i++) 
        {
            triangle[i] = new int[i + 1];
        }

        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};

        int x = 0, y = 0;
        int dir = 0;
        int num = 1;
        int maxNum = n * (n + 1) / 2;

        while (num <= maxNum) 
        {
            triangle[x][y] = num++;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || nx >= n || ny < 0 || ny > nx || triangle[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            
            x = nx;
            y = ny;
        }

        int[] answer = new int[maxNum];
        int idx = 0;
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < triangle[i].length; j++) 
            {
                answer[idx++] = triangle[i][j];
            }
        }

        return answer;
    }
}
