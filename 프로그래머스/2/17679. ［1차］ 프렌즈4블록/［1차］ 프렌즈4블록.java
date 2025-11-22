import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] b = new char[m][n];
        for (int i = 0; i < m; i++) {
            b[i] = board[i].toCharArray();
        }
        int removed = 0;

        while (true) {
            boolean[][] mark = new boolean[m][n];
            boolean any = false;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = b[i][j];
                    if (c == 0) {
                        continue;
                    }
                    if (b[i + 1][j] == c && b[i][j + 1] == c && b[i + 1][j + 1] == c) {
                        mark[i][j] = mark[i + 1][j] = mark[i][j + 1] = mark[i + 1][j + 1] = true;
                        any = true;
                    }
                }
            }

            if (!any) {
                break;
            }

            for (int j = 0; j < n; j++) {
                int write = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (!mark[i][j]) {
                        b[write--][j] = b[i][j];
                    }
                    else {
                        removed++;
                    }
                }
                while (write >= 0) {
                    b[write--][j] = 0;
                }
            }
        }

        return removed;
    }
}
