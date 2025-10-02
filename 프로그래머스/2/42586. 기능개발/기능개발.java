import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int days = (int)Math.ceil((double)remain / speeds[i]);
            q.offer(days);
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int standard = q.poll();
            int cnt = 1;
            
            while(!q.isEmpty() && q.peek() <= standard) {
                q.poll();
                cnt++;
            }
            
            result.add(cnt);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}