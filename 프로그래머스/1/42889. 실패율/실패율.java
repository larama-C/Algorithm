import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[][] arr = new int[N][2];
        
        for (int stage : stages) {
            if (stage <= N) {
                arr[stage - 1][0]++; 
            }
        }

        int players = stages.length;
        for (int i = 0; i < N; i++) {
            arr[i][1] = players;
            players -= arr[i][0];
        }
        
        double [][] answer = new double[N][2];
        
        for(int i = 0; i < N; i++)
        {
            answer[i][0] = i + 1;
            if (arr[i][1] == 0) {
                answer[i][1] = 0;
            } else {
                answer[i][1] = (double) arr[i][0] / arr[i][1];
            }
        }
        
        Arrays.sort(answer, (a,b) -> {
            int cmp = Double.compare(b[1], a[1]);
            if (cmp == 0) return Double.compare(a[0], b[0]);
            return cmp;
        });
        
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = (int) answer[i][0];
        }
        
        return result;
    }
}