import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        List<Integer> result = new ArrayList<>();
        int dictIndex = 27;
        int i = 0;

        while (i < msg.length()) {
            String w = "" + msg.charAt(i);
            int j = i + 1;

            while (j <= msg.length() && dict.containsKey(msg.substring(i, j))) {
                w = msg.substring(i, j);
                j++;
            }

            result.add(dict.get(w));

            if (j <= msg.length()) {
                dict.put(msg.substring(i, j), dictIndex++);
            }

            i += w.length();
        }

        int[] answer = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            answer[k] = result.get(k);
        }
        return answer;
    }
}
