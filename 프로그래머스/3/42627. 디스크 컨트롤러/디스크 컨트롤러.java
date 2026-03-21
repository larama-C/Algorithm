import java.util.*;

class Solution {
    public int solution(int[][] jobs) {

        int n = jobs.length;

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = jobs[i][0];
            arr[i][1] = jobs[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[2] - b[2];
            }
        });

        int time = 0;
        int idx = 0;
        int total = 0;
        int count = 0;

        while (count < n) {

            while (idx < n && arr[idx][0] <= time) {
                pq.offer(arr[idx]);
                idx++;
            }

            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                time += cur[1];
                total += (time - cur[0]);
                count++;
            } else {
                time = arr[idx][0];
            }
        }

        return total / n;
    }
}