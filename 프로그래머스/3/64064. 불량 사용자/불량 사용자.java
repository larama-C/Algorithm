import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {

        Set<String> set = new HashSet<>();

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int depth = cur[0];
            int mask = cur[1];

            if (depth == banned_id.length) {
                set.add(String.valueOf(mask));
                continue;
            }

            for (int i = 0; i < user_id.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    continue;
                }

                String user = user_id[i];
                String banned = banned_id[depth];

                if (user.length() != banned.length()) {
                    continue;
                }

                boolean ok = true;
                for (int j = 0; j < user.length(); j++) {
                    if (banned.charAt(j) != '*' && user.charAt(j) != banned.charAt(j)) {
                        ok = false;
                        break;
                    }
                }

                if (!ok) {
                    continue;
                }

                stack.push(new int[]{depth + 1, mask | (1 << i)});
            }
        }

        return set.size();
    }
}