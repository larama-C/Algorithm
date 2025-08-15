import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int answer = n;

        for (int i = 0; i < lost.length; i++) 
        {
            for (int j = 0; j < reserve.length; j++) 
            {
                if (lost[i] == -1 || reserve[j] == -1) 
                {
                    continue;
                }
                
                if (lost[i] == reserve[j]) 
                {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) 
        {  
            if (lost[i] == -1) 
            {
                continue;
            }
            boolean borrowed = false;
        
            for (int j = 0; j < reserve.length; j++) 
            {
                if (reserve[j] == -1) 
                {
                    continue;
                }
                
                if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) 
                {
                    lost[i] = -1;
                    reserve[j] = -1;
                    borrowed = true;
                    break;
                }
            }
            
            if (!borrowed) 
            {
                answer--;
            }
        }
        
        return answer;
    }
}
