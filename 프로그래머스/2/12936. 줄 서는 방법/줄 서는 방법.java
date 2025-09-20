import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) 
        {
            list.add(i);
        }
        
        int[] answer = new int[n];
        k--;

        for (int i = 0; i < n; i++) 
        {
            long fact = factorial(n - 1 - i);
            int idx = (int)(k / fact);
            answer[i] = list.remove(idx);
            k %= fact;
        }
        
        return answer;
    }

    private long factorial(int num) {
        long result = 1;
        
        for (int i = 2; i <= num; i++) 
        {
            result *= i;
        }
        
        return result;
    }
}
