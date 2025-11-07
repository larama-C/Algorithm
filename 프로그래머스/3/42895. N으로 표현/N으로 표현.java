import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }

        List<Set<Integer>> dp = new ArrayList<>(9);
        
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        int concat = 0;
        for (int i = 1; i <= 8; i++) {
            concat = concat * 10 + N;
            dp.get(i).add(concat);
            if (concat == number) {
                return i;
            }

            for (int j = 1; j < i; j++) {
                Set<Integer> A = dp.get(j);
                Set<Integer> B = dp.get(i - j);

                for (int a : A) {
                    for (int b : B) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(b - a);
                        dp.get(i).add(a * b);
                        if (b != 0) {
                            dp.get(i).add(a / b);
                        }
                        if (a != 0) { 
                            dp.get(i).add(b / a);
                        }
                    }
                }
            }
            
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}