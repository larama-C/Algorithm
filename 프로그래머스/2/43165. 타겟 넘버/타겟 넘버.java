import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{0, 0});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int idx = cur[0];
            int sum = cur[1];

            if (idx == numbers.length) {
                if (sum == target) answer++;
                continue;
            }
            
            stack.push(new int[]{idx + 1, sum + numbers[idx]});
            stack.push(new int[]{idx + 1, sum - numbers[idx]});
        }

        return answer;
    }
}