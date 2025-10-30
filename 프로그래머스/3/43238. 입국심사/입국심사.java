import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long min = 1;
        long max = (long) times[times.length - 1] * n;
        
        long answer = max;
        
        while(min <= max) {
            long avg = (min + max) / 2;
            long total = 0;
            
            for(int t : times) {
                total += avg / t;
                if(total >= n) {
                    break;
                }
            }
            
            if(total >= n) {
                answer = avg;
                max = avg - 1;
            } else {
                min = avg + 1;
            }
        }
        
        return answer;
    }
}