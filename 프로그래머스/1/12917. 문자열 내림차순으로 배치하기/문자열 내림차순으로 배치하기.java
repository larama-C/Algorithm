class Solution {
    public String solution(String s) {
        int[] stoascii = new int[s.length()];
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            stoascii[i] = s.charAt(i);
        }

        for (int i = 0; i < stoascii.length - 1; i++) {
            for (int j = 0; j < stoascii.length - i - 1; j++) {
                if (stoascii[j] < stoascii[j + 1]) {
                    int temp = stoascii[j];
                    stoascii[j] = stoascii[j + 1];
                    stoascii[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            answer += (char)stoascii[i];
        }

        return answer;
    }
}
