import java.util.*;

class Solution {
    Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }

        for (int c : course) {
            map = new HashMap<>();
            int max = 0;

            for (String order : orders) {
                if (order.length() >= c) {
                    dfs(order, c, 0, "", 0);
                }
            }

            for (int v : map.values()) {
                max = Math.max(max, v);
            }
            
            if (max < 2) {
                continue;
            }

            for (String key : map.keySet()) {
                if (map.get(key) == max) result.add(key);
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    void dfs(String order, int len, int idx, String cur, int cnt) {
        if (cnt == len) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            return;
        }
        for (int i = idx; i < order.length(); i++) {
            dfs(order, len, i + 1, cur + order.charAt(i), cnt + 1);
        }
    }
}