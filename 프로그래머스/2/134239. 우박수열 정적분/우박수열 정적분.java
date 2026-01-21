import java.util.*;

class Solution {
    public double[] solution(int start, int[][] intervals) {
        List<Long> values = new ArrayList<>();
        long num = start;
        values.add(num);

        while (num != 1) {
            if ((num & 1) == 0) {
                num /= 2;
            }
            else {
                num = num * 3 + 1;
            }
            values.add(num);
        }

        int length = values.size() - 1;

        double[] areaSum = new double[length + 1];
        for (int i = 0; i < length; i++) {
            areaSum[i + 1] = areaSum[i] + (values.get(i) + values.get(i + 1)) / 2.0;
        }

        double[] result = new double[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = length + intervals[i][1];

            if (left > right) {
                result[i] = -1.0;
            }
            else {
                result[i] = areaSum[right] - areaSum[left];
            }
        }

        return result;
    }
}