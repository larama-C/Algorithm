import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);

        for (int i = mats.length - 1; i >= 0; i--) {
            if (canPlaceMat(mats[i], park)) {
                return mats[i];
            }
        }
        return -1;
    }

    private boolean canPlaceMat(int matSize, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;

        for (int r = 0; r <= rows - matSize; r++) {
            for (int c = 0; c <= cols - matSize; c++) {
                if (SeatCheck(r, c, park, matSize)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean SeatCheck(int startRow, int startCol, String[][] park, int matSize) {
    for (int i = startRow; i < startRow + matSize; i++) {
        for (int j = startCol; j < startCol + matSize; j++) {
            if (!park[i][j].equals("-1")) {
                return false;
            }
        }
    }
    return true;
}
}