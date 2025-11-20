import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[][] arr = new String[files.length][3];
        int[] nums = new int[files.length];

        for (int i = 0; i < files.length; i++) {
            String f = files[i];
            int idx = 0;

            while (idx < f.length() && !Character.isDigit(f.charAt(idx))) {
                idx++;
            }

            String head = f.substring(0, idx);

            int start = idx;
            while (idx < f.length() && Character.isDigit(f.charAt(idx)) && idx - start < 5) {
                idx++;
            }

            int number = Integer.parseInt(f.substring(start, idx));

            arr[i][0] = files[i];
            arr[i][1] = head.toLowerCase();
            arr[i][2] = String.valueOf(i);
            nums[i] = number;
        }

        Arrays.sort(arr, (a, b) -> {
            int i1 = Integer.parseInt(a[2]);
            int i2 = Integer.parseInt(b[2]);

            int cmpHead = a[1].compareTo(b[1]);
            if (cmpHead != 0) {
                return cmpHead;
            }

            int cmpNum = nums[i1] - nums[i2];
            if (cmpNum != 0) {
                return cmpNum;
            }

            return i1 - i2;
        });

        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = arr[i][0];
        }

        return answer;
    }
}
