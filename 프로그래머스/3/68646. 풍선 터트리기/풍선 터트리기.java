class Solution {
    public int solution(int[] a) {
        int n = a.length;

        if (n <= 2) {
            return n;
        }

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            if (leftMin[i - 1] < a[i]) {
                leftMin[i] = leftMin[i - 1];
            } else {
                leftMin[i] = a[i];
            }
        }

        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (rightMin[i + 1] < a[i]) {
                rightMin[i] = rightMin[i + 1];
            } else {
                rightMin[i] = a[i];
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }

        return answer;
    }
}