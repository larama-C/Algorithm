class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = {10, 20, 30, 40};
        int maxPlus = 0;
        int maxSales = 0;
        int m = emoticons.length;

        int total = (int) Math.pow(4, m);

        for (int i = 0; i < total; i++) {
            int temp = i;
            int[] rate = new int[m];

            for (int j = 0; j < m; j++) {
                rate[j] = discounts[temp % 4];
                temp /= 4;
            }

            int plus = 0;
            int sales = 0;

            for (int[] user : users) {
                int sum = 0;

                for (int j = 0; j < m; j++) {
                    if (rate[j] >= user[0]) {
                        sum += emoticons[j] * (100 - rate[j]) / 100;
                    }
                }

                if (sum >= user[1]) plus++;
                else sales += sum;
            }

            if (plus > maxPlus || (plus == maxPlus && sales > maxSales)) {
                maxPlus = plus;
                maxSales = sales;
            }
        }

        return new int[]{maxPlus, maxSales};
    }
}
