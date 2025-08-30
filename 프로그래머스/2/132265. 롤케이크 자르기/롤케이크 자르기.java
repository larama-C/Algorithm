import java.util.Arrays;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] lcnt = new int[10001];
        int[] rcnt = new int[10001];
        
        int lucnt = 0;
        int rucnt = 0;
        
        for (int t : topping) {
            if (rcnt[t] == 0) {
                rucnt++;
            }
            rcnt[t]++;
        }
        
        for (int t : topping) {
            if (lcnt[t] == 0) {
                lucnt++;
            }
            lcnt[t]++;

            rcnt[t]--;
            if (rcnt[t] == 0) {
                rucnt--;
            }
            
            if (lucnt == rucnt) {
                answer++;
            }
        }
        
        return answer;
    }
}
