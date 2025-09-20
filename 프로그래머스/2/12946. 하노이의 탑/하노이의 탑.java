import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]> answer = new ArrayList<>();
        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{n, 1, 3, 2});
        
        while (!stack.isEmpty()) 
        {
            int[] cur = stack.pop();
            int disk = cur[0], start = cur[1], end = cur[2], via = cur[3];
            
            if (disk == 1)
            {
                answer.add(new int[]{start, end});
            }
            else
            {
                stack.push(new int[]{disk - 1, via, end, start});
                stack.push(new int[]{1, start, end, via});
                stack.push(new int[]{disk - 1, start, via, end});
            }
        }
        
        int[][] result = new int[answer.size()][2];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
