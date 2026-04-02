class Solution {
    public boolean solution(int[][] key, int[][] lock) {

        int n = lock.length;
        int m = key.length;

        int size = n * 3;
        int[][] newLock = new int[size][size];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + n][j + n] = lock[i][j];
            }
        }

        for (int rot = 0; rot < 4; rot++) {

            int[][] rotated = new int[m][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    rotated[j][m - 1 - i] = key[i][j];
                }
            }
            key = rotated;

            for (int x = 0; x <= size - m; x++) {
                for (int y = 0; y <= size - m; y++) {

                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] += key[i][j];
                        }
                    }

                    boolean ok = true;
                    for (int i = n; i < 2 * n; i++) {
                        for (int j = n; j < 2 * n; j++) {
                            if (newLock[i][j] != 1) {
                                ok = false;
                                break;
                            }
                        }
                        if (!ok) break;
                    }

                    if (ok) return true;

                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }

        return false;
    }
}