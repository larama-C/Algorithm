class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = 1;

        for (int i = 0; i < n; i++) {

            int left = i;
            int right = i;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                answer = Math.max(answer, right - left + 1);
                left--;
                right++;
            }

            left = i;
            right = i + 1;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                answer = Math.max(answer, right - left + 1);
                left--;
                right++;
            }
        }

        return answer;
    }
}