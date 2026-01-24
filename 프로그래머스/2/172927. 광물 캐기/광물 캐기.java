import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int max = Math.min(minerals.length, (picks[0] + picks[1] + picks[2]) * 5);
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < max; i += 5) {
            int d = 0, ir = 0, s = 0;

            for (int j = i; j < i + 5 && j < max; j++) {
                if (minerals[j].equals("diamond")) {
                    d++;
                } else if (minerals[j].equals("iron")) {
                    ir++;
                } else {
                    s++;
                }
            }

            list.add(new int[]{d, ir, s});
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int[] a = list.get(i);
                int[] b = list.get(j);

                if (a[0] < b[0] ||
                    (a[0] == b[0] && a[1] < b[1]) ||
                    (a[0] == b[0] && a[1] == b[1] && a[2] < b[2])) {

                    list.set(i, b);
                    list.set(j, a);
                }
            }
        }

        int idx = 0;
        int answer = 0;

        for (int p = 0; p < 3; p++) {
            while (picks[p]-- > 0 && idx < list.size()) {
                int[] g = list.get(idx++);
                if (p == 0) {
                    answer += g[0] + g[1] + g[2];
                } else if (p == 1) {
                    answer += g[0] * 5 + g[1] + g[2];
                } else {
                    answer += g[0] * 25 + g[1] * 5 + g[2];
                }
            }
        }

        return answer;
    }
}