import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0; 
        int n = order.length;
        int idx = 0;
        
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < n; i++)
        {
            if(i + 1 == order[idx])
            {
                answer++;
                idx++;
                
                while(!s.isEmpty() && s.peek() == order[idx])
                {
                    s.pop();
                    answer++;
                    idx++;
                }
            }
            else
            {
                s.push(i + 1);
            }
        }
        
        return answer;
    }
}
    