import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int length = cards.length;
        boolean[] opened = new boolean[length];
        List<Integer> sizes = new ArrayList<>();

        for (int start = 0; start < length; start++) {
            if (opened[start]) continue;

            int box = start;
            int size = 0;

            while (!opened[box]) {
                opened[box] = true;
                box = cards[box] - 1;
                size++;
            }

            sizes.add(size);
        }

        if (sizes.size() < 2) {
            return 0;
        }

        sizes.sort(Collections.reverseOrder());

        return sizes.get(0) * sizes.get(1);
    }
}
