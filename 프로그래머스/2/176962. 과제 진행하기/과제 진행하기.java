import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {

        int n = plans.length;

        int[][] arr = new int[n][2];
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = plans[i][0];

            String[] t = plans[i][1].split(":");
            int start = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);

            arr[i][0] = start;
            arr[i][1] = Integer.parseInt(plans[i][2]);
        }

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;

        Arrays.sort(order, (a, b) -> arr[a][0] - arr[b][0]);

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> remain = new Stack<>();

        String[] answer = new String[n];
        int idx = 0;

        for (int i = 0; i < n - 1; i++) {

            int cur = order[i];
            int next = order[i + 1];

            int available = arr[next][0] - arr[cur][0];
            int play = arr[cur][1];

            if (play <= available) {

                answer[idx++] = names[cur];
                int remainTime = available - play;

                while (remainTime > 0 && !stack.isEmpty()) {

                    int task = stack.pop();
                    int r = remain.pop();

                    if (r <= remainTime) {
                        remainTime -= r;
                        answer[idx++] = names[task];
                    } else {
                        r -= remainTime;
                        stack.push(task);
                        remain.push(r);
                        remainTime = 0;
                    }
                }

            } else {

                stack.push(cur);
                remain.push(play - available);
            }
        }

        answer[idx++] = names[order[n - 1]];

        while (!stack.isEmpty()) {
            answer[idx++] = names[stack.pop()];
        }

        return answer;
    }
}