import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int t : tangerine) 
        {
            countMap.put(t, countMap.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(countMap.values());
        counts.sort(Collections.reverseOrder());
        
        int sum = 0;
        
        for (int c : counts)
        {
            sum += c;
            answer++;
            if (sum >= k)
            {
                break;
            }
        }
        
        return answer;
    }
}
