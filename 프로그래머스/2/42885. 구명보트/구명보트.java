import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int front = 0;
        int last = people.length - 1;
        
        Arrays.sort(people);
        
        while(front <= last)
        {
            if(people[front] + people[last] <= limit)
            {
                front++;
            }
            last--;
            answer++;  
        }
        
        return answer;
    }
}