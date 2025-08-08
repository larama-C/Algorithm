class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ((int)ch >= 65 && (int)ch <= 90) {
                answer.append((char)(((ch - 'A' + n) % 26) + 'A'));
            } else if ((int)ch >= 97 && (int)ch <= 122) {
                answer.append((char)(((ch - 'a' + n) % 26) + 'a'));
            } else {
                answer.append(ch);
            }
        }

        return answer.toString();
    }
}