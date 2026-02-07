class Solution {
    public long solution(int r1, int r2) {
        long result = 0;

        long r1Pow = (long) r1 * r1;
        long r2Pow = (long) r2 * r2;

        for (int x = 1; x <= r2; x++) {
            long xPow = (long) x * x;

            long yMax = (long) Math.floor(Math.sqrt(r2Pow - xPow));

            long yMin;
            if (xPow >= r1Pow) {
                yMin = 1;
            } else {
                yMin = (long) Math.ceil(Math.sqrt(r1Pow - xPow));
            }

            if (yMax >= yMin) {
                result += (yMax - yMin + 1);
            }
        }

        result *= 4;
        result += 4L * (r2 - r1 + 1);

        return result;
    }
}
