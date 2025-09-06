import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {   
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) 
        {
            queue.add(i);
        }
        
        int order = 0;

        while (!queue.isEmpty())
        {
            int idx = queue.poll();
            boolean hasHigher = false;

            for (int i : queue) 
            {
                if (priorities[i] > priorities[idx]) 
                {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) 
            {
                queue.add(idx);
            } 
            else 
            {
                order++;
                if (idx == location) return order;
            }
        }
        
        return order;
    }
}