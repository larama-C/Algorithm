class Solution {

    int[] answer = new int[2]; 

    public int[] solution(int[][] arr) {
        dfs(arr, 0, 0, arr.length);
        return answer;
    }

    private void dfs(int[][] arr, int r, int c, int size) {
        int value = arr[r][c];
        boolean same = true;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != value) {
                    same = false;
                }
            }
        }

        if (same) {
            answer[value]++;
        } else {
            int half = size / 2;
            dfs(arr, r, c, half);
            dfs(arr, r, c + half, half);
            dfs(arr, r + half, c, half);
            dfs(arr, r + half, c + half, half);
        }
    }
}
