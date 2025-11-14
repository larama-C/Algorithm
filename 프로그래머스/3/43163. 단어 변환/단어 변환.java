import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean exists = false;
        
        for (String w : words) {
            if (w.equals(target)) {
                exists = true;
            }
        }
        
        if (!exists) {
            return 0;
        }

        boolean[] visited = new boolean[words.length];
        Queue<String[]> q = new LinkedList<>();
        q.offer(new String[]{begin, "0"});

        while (!q.isEmpty()) {
            String[] cur = q.poll();
            String word = cur[0];
            int depth = Integer.parseInt(cur[1]);

            if (word.equals(target)) {
                return depth;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i]) {
                    int diff = 0;
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) != words[i].charAt(j)) {
                            diff++;
                        }
                        if (diff > 1) {
                            break;
                        }
                    }
                    if (diff == 1) {
                        visited[i] = true;
                        q.offer(new String[]{words[i], String.valueOf(depth + 1)});
                    }
                }
            }
        }
        return 0;
    }
}
