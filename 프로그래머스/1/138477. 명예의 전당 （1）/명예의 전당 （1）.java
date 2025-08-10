import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int day = 0;
        List<Integer> arr = new ArrayList<>();
        
        while(day < score.length)
        {
            for(int i = 0; i <= day; i++)
            {
                arr.add(score[i]);
            }
            Collections.sort(arr, Collections.reverseOrder());
            if(day >= k)
            {
                answer[day] = arr.get(k - 1);
            }
            else
            {
                answer[day] = Collections.min(arr);
            }
            arr.clear();
            day++;
        }
              
        return answer;
    }
}