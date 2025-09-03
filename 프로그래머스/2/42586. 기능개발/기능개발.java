import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] arr = new int[speeds.length];
        
        for(int i = 0; i < speeds.length; i++)
        {
            int t = 100 - progresses[i];
            arr[i] = (t % speeds[i] == 0) ? (t / speeds[i]) : (t / speeds[i] + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        
        int standard = arr[0];
        int cnt = 1;
        
        for(int i = 1; i < speeds.length; i++)
        {
            if(arr[i] <= standard)
            {
                cnt++;
            }
            else
            {
                result.add(cnt);
                cnt = 1;
                standard = arr[i];
            }
        }
        result.add(cnt);
        
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}