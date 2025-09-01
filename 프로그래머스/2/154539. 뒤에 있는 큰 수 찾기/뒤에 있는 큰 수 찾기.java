import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Arrays.fill(answer, -1);
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < numbers.length; i++)
        {
            while(!dq.isEmpty() && numbers[dq.peek()] < numbers[i])
            {
                answer[dq.pop()] = numbers[i];
            }
            dq.push(i);
        }
        
        return answer;
    }
}