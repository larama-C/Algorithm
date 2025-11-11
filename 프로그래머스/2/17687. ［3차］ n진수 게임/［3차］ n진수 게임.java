class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sequence = new StringBuilder();
        int number = 0;

        while (sequence.length() < t * m) {
            sequence.append(Integer.toString(number++, n).toUpperCase());
        }

        StringBuilder answer = new StringBuilder();
        for (int i = p - 1; i < t * m; i += m) {
            answer.append(sequence.charAt(i));
            if (answer.length() == t) break;
        }

        return answer.toString();
    }
}
