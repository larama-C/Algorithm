import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Queue<Integer> arr = new LinkedList<>();

        // 1부터 N까지 초기화
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }

        // 카드 게임 로직
        while (arr.size() > 1) {
            arr.poll();             // 맨 앞 카드 버림
            int temp = arr.poll();  // 그 다음 카드를 꺼내서
            arr.add(temp);          // 맨 뒤에 추가
        }

        System.out.println(arr.peek()); // 마지막 카드 출력
    }
}
