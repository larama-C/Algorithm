class Solution {
    public int solution(int n) {
        String s = "";
        while (n > 0) {
            s += n % 3;
            n /= 3;
        }

        int answer = 0;
        int multiplier = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = s.charAt(i) - '0';
            answer += digit * multiplier;
            multiplier *= 3;
        }

        return answer;
    }
}