import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int camera = routes[0][1];
        int count = 1;

        for (int i = 1; i < routes.length; i++) {
            if (camera < routes[i][0]) {
                camera = routes[i][1];
                count++;
            }
        }

        return count;
    }
}
