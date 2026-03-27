import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        int n = data.length;

        for (int i = 0; i < n - 1; i++) {
            int idx = i;

            for (int j = i + 1; j < n; j++) {

                if (data[j][col - 1] < data[idx][col - 1] ||
                   (data[j][col - 1] == data[idx][col - 1] && data[j][0] > data[idx][0])) {
                    idx = j;
                }
            }

            int[] temp = data[i];
            data[i] = data[idx];
            data[idx] = temp;
        }

        int answer = 0;

        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;

            for (int val : data[i - 1]) {
                sum += val % i;
            }

            answer ^= sum;
        }

        return answer;
    }
}