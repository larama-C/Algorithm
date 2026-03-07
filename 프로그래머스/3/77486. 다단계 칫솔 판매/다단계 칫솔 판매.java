import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        Map<String, Integer> map = new HashMap<>();
        int n = enroll.length;

        for (int i = 0; i < n; i++) {
            map.put(enroll[i], i);
        }

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            if (referral[i].equals("-")) parent[i] = -1;
            else parent[i] = map.get(referral[i]);
        }

        int[] profit = new int[n];

        for (int i = 0; i < seller.length; i++) {

            int idx = map.get(seller[i]);
            int money = amount[i] * 100;

            while (idx != -1 && money > 0) {

                int give = money / 10;
                int keep = money - give;

                profit[idx] += keep;

                idx = parent[idx];
                money = give;
            }
        }

        return profit;
    }
}