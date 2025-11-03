class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n+1][m+1];
        
        boolean[][] flooding = new boolean[n+1][m+1];
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];
            flooding[y][x] = true;
        }
        
        arr[1][1] = 1;
        
         for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (flooding[i][j]) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % 1000000007;
                }
            }
        }
        
        return arr[n][m];
    }
}