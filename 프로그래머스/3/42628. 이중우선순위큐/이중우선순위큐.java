import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String op : operations) {
            char command = op.charAt(0);
            int value = Integer.parseInt(op.substring(2));

            if (command == 'I') {
                map.put(value, map.getOrDefault(value, 0) + 1);
            } else {
                if (map.isEmpty()) continue;

                int key = (value == 1) ? map.lastKey() : map.firstKey();
                int count = map.get(key);

                if (count == 1) {
                    map.remove(key);
                } else {
                    map.put(key, count - 1);
                }
            }
        }

        if (map.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }

        return answer;
    }
}