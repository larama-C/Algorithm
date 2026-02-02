import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int row = relation.length;
        int col = relation[0].length;

        List<Integer> candidateKeys = new ArrayList<>();

        for (int mask = 1; mask < (1 << col); mask++) {
            boolean isMinimal = true;
            for (int key : candidateKeys) {
                if ((key & mask) == key) {
                    isMinimal = false;
                    break;
                }
            }
            if (!isMinimal) continue;

            Set<String> set = new HashSet<>();
            for (int r = 0; r < row; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < col; c++) {
                    if ((mask & (1 << c)) != 0) {
                        sb.append(relation[r][c]).append("|");
                    }
                }
                set.add(sb.toString());
            }

            if (set.size() == row) {
                candidateKeys.add(mask);
            }
        }

        return candidateKeys.size();
    }
}