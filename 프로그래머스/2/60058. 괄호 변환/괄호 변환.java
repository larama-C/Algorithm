class Solution {
    public String solution(String p) {
        String answer = "";

        if (p.isEmpty()) return answer;

        int cnt = 0, idx = 0;
        boolean correct = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                cnt++;
            }
            else {
                cnt--;
            }

            if (cnt < 0) {
                correct = false;
            }
            if (cnt == 0) {
                idx = i + 1;
                break;
            }
        }

        String u = p.substring(0, idx);
        String v = p.substring(idx);

        if (correct) {
            answer = u + solution(v);
            return answer;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(v));
        sb.append(")");

        for (int i = 1; i < u.length() - 1; i++) {
            sb.append(u.charAt(i) == '(' ? ')' : '(');
        }

        answer = sb.toString();
        return answer;
    }
}
