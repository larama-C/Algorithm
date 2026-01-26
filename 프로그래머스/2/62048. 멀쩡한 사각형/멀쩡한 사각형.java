class Solution {
    public long solution(int w, int h) {
        long width = w;
        long height = h;

        long x = width;
        long y = height;

        while (y != 0) {
            long remain = x % y;
            x = y;
            y = remain;
        }

        long Divisor = x;

        return width * height - (width + height - Divisor);
    }
}
