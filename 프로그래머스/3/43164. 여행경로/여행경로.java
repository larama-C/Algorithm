import java.util.*;

class Solution {
    List<String> route = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (String[] t : tickets) {
            map.computeIfAbsent(t[0], k -> new PriorityQueue<>()).add(t[1]);
        }

        dfs("ICN", map);

        Collections.reverse(route);
        return route.toArray(new String[0]);
    }

    void dfs(String cur, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> pq = map.get(cur);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), map);
        }

        route.add(cur);
    }
}