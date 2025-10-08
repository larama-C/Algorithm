import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = progresses.length - 1; i >= 0; i--) {
            int remain = 100 - progresses[i];
            int days = (int)Math.ceil((double)remain / speeds[i]);
            stack.push(days);
        }

        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            int standard = stack.pop();
            int cnt = 1;

            while (!stack.isEmpty() && stack.peek() <= standard) {
                stack.pop();
                cnt++;
            }
            result.add(cnt);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
