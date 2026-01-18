class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];

            if (x % 2 == 0) {
                answer[i] = x + 1;
            }
            else {
                long bit = 1;
                while ((x & bit) != 0) {
                    bit <<= 1;
                }

                answer[i] = x + bit - (bit >> 1);
            }
        }

        return answer;
    }
}
