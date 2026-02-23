import java.util.*;

class Solution {
    static class Point {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

        int n = line.length;

        for (int i = 0; i < n - 1; i++) {
            long A = line[i][0];
            long B = line[i][1];
            long C = line[i][2];

            for (int j = i + 1; j < n; j++) {
                long D = line[j][0];
                long E = line[j][1];
                long F = line[j][2];

                long den = A * E - B * D;
                if (den == 0) {
                    continue;
                }

                long xNumer = B * F - C * E;
                long yNumer = C * D - A * F;

                if (xNumer % den != 0) {
                    continue;
                }
                if (yNumer % den != 0) {
                    continue;
                }

                long x = xNumer / den;
                long y = yNumer / den;

                points.add(new Point(x, y));

                if (x < minX) {
                    minX = x;
                }
                if (x > maxX) {
                    maxX = x;
                }
                if (y < minY) {
                    minY = y;
                }
                if (y > maxY) {
                    maxY = y;
                }
            }
        }

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        char[][] board = new char[height][width];
        for (int r = 0; r < height; r++) Arrays.fill(board[r], '.');

        for (Point p : points) {
            int col = (int) (p.x - minX);
            int row = (int) (maxY - p.y);
            board[row][col] = '*';
        }

        String[] answer = new String[height];
        for (int r = 0; r < height; r++) {
            answer[r] = new String(board[r]);
        }
        
        return answer;
    }
}