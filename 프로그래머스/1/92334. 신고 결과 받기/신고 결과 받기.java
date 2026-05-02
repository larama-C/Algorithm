import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, Set<String>> reportMap = new HashMap<>();
        
        for (String id : id_list) {
            reportCount.put(id, 0);
            reportMap.put(id, new HashSet<>());
        }
        
        Set<String> set = new HashSet<>(Arrays.asList(report));
        
        for (String s : set) {
            String[] parts = s.split(" ");
            String from = parts[0];
            String to = parts[1];
            
            reportMap.get(from).add(to);
            reportCount.put(to, reportCount.get(to) + 1);
        }
        
        Set<String> banned = new HashSet<>();
        for (String id : reportCount.keySet()) {
            if (reportCount.get(id) >= k) {
                banned.add(id);
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            
            for (String target : reportMap.get(user)) {
                if (banned.contains(target)) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}