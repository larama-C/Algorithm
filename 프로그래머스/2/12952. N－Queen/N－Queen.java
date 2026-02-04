class Solution {
    int answer = 0;

    public int solution(int n) {
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];
        dfs(0, n, col, diag1, diag2);
        return answer;
    }

    private void dfs(int row, int n, boolean[] col, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            answer++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col[c] || diag1[row + c] || diag2[row - c + n]) {
                continue;
            }

            col[c] = true;
            diag1[row + c] = true;
            diag2[row - c + n] = true;

            dfs(row + 1, n, col, diag1, diag2);

            col[c] = false;
            diag1[row + c] = false;
            diag2[row - c + n] = false;
        }
    }
}
