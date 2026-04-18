import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String[]> logs = new ArrayList<>();

        for (String r : record) {
            String[] split = r.split(" ");
            String action = split[0];
            String uid = split[1];

            if (action.equals("Enter")) {
                map.put(uid, split[2]);
                logs.add(new String[]{uid, "Enter"});
            } else if (action.equals("Leave")) {
                logs.add(new String[]{uid, "Leave"});
            } else {
                map.put(uid, split[2]);
            }
        }

        String[] answer = new String[logs.size()];
        int idx = 0;

        for (String[] log : logs) {
            String uid = log[0];
            String action = log[1];
            String nickname = map.get(uid);

            if (action.equals("Enter")) {
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else {
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}