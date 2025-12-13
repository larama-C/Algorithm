class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        int baseA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            baseA = calc(baseA, arrayA[i]);
        }

        int baseB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            baseB = calc(baseB, arrayB[i]);
        }

        int answer = 0;
        if (check(baseA, arrayB)) answer = baseA;
        if (check(baseB, arrayA)) answer = Math.max(answer, baseB);

        return answer;
    }

    private boolean check(int d, int[] arr) {
        for (int n : arr) {
            if (n % d == 0) return false;
        }
        return true;
    }

    private int calc(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
