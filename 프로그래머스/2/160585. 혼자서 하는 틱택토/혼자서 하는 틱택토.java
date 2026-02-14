class Solution {
    public int solution(String[] board) {
        int oTotal = 0;
        int xTotal = 0;

        int[] oCount = new int[8];
        int[] xCount = new int[8];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char cell = board[row].charAt(col);

                if (cell == 'O') {
                    oTotal++;
                    oCount[row]++;
                    oCount[col + 3]++;
                    if (row == col) oCount[6]++;
                    if (row + col == 2) oCount[7]++;
                } else if (cell == 'X') {
                    xTotal++;
                    xCount[row]++;
                    xCount[col + 3]++;
                    if (row == col) xCount[6]++;
                    if (row + col == 2) xCount[7]++;
                }
            }
        }

        if (oTotal < xTotal || oTotal > xTotal + 1) return 0;

        boolean oWin = false;
        boolean xWin = false;

        for (int i = 0; i < 8; i++) {
            if (oCount[i] == 3) oWin = true;
            if (xCount[i] == 3) xWin = true;
        }

        if (oWin && xWin) return 0;
        if (oWin && oTotal != xTotal + 1) return 0;
        if (xWin && oTotal != xTotal) return 0;

        return 1;
    }
}
