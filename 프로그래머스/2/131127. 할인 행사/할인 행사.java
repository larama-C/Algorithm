class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        
        for (int i = 0; i <= discount.length - 10; i++) {
            int[] count = new int[want.length];

            for (int j = i; j < i + 10; j++) {
                for (int k = 0; k < want.length; k++) {
                    if (discount[j].equals(want[k])) {
                        count[k]++;
                    }
                }
            }

            boolean isValid = true;
            for (int k = 0; k < want.length; k++) {
                if (count[k] < number[k]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) result++;
        }

        return result;
    }
}