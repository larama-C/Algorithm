import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                answer = Math.min(answer, count(i, j));
            }
        }

        System.out.println(answer);
    }

    static int count(int x, int y) {
        int caseW = 0;
        int caseB = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char current = board[x + i][y + j];

                if ((i + j) % 2 == 0) {
                    if (current != 'W') caseW++;
                    if (current != 'B') caseB++;
                } else {
                    if (current != 'B') caseW++;
                    if (current != 'W') caseB++;
                }
            }
        }

        return Math.min(caseW, caseB);
    }
}