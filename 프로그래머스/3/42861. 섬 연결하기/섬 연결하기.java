import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int[] parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int count = 0;
        
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];
            
            int rootA = from;
            while (parent[rootA] != rootA) {
                rootA = parent[rootA];
            }
            
            int rootB = to;
            while (parent[rootB] != rootB) {
                rootB = parent[rootB];
            }
            
            if (rootA != rootB) {
                parent[rootB] = rootA;
                answer += cost;
                count++;
            }
            
            if (count == n - 1) {
                break;
            }
        }
        
        return answer;
    }
}