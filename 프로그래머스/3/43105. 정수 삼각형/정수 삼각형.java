class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        
        int [][] arr = new int[n][n];
        
        arr[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    arr[i][j] = arr[i - 1][j - 1] + triangle[i][j];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j - 1], arr[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        for (int num : arr[n - 1]) {
            answer = Math.max(answer, num);
        }
        
        return answer;
    }
}