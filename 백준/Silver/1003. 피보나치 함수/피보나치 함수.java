import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[][] dp = new int[41][2];

        dp[0][0] = 1; //0일때 0 호출값
        dp[0][1] = 0; //0일때 1 호출값
        dp[1][0] = 0; //1일때 0 호출값
        dp[1][1] = 1; //1일때 1 호출값

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}