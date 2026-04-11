import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt(); //회의 시작 시간
            meetings[i][1] = sc.nextInt(); //회의 종료 시간
        }

        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int cnt = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= end) {
                end = meetings[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}