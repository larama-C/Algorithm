import java.util.*;

class Solution {
    static class State {
        int row, col, direction, totalCost;
        State(int row, int col, int direction, int totalCost) {
            this.row = row;
            this.col = col;
            this.direction = direction;
            this.totalCost = totalCost;
        }
    }

    public int solution(int[][] board) {
        int size = board.length;
        int INF = Integer.MAX_VALUE;

        int[][][] minCost = new int[size][size][4];
        for (int[][] a : minCost)
            for (int[] b : a)
                Arrays.fill(b, INF);

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        Queue<State> queue = new LinkedList<>();

        queue.add(new State(0, 0, 1, 0));
        queue.add(new State(0, 0, 2, 0));
        minCost[0][0][1] = 0;
        minCost[0][0][2] = 0;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            for (int nd = 0; nd < 4; nd++) {
                int nextRow = cur.row + dRow[nd];
                int nextCol = cur.col + dCol[nd];

                if (nextRow < 0 || nextCol < 0 || nextRow >= size || nextCol >= size) {
                    continue;
                }
                if (board[nextRow][nextCol] == 1) {
                    continue;
                }

                int nextCost = cur.totalCost + 100;
                if (cur.direction != nd) {
                    nextCost += 500;
                }

                if (minCost[nextRow][nextCol][nd] > nextCost) {
                    minCost[nextRow][nextCol][nd] = nextCost;
                    queue.add(new State(nextRow, nextCol, nd, nextCost));
                }
            }
        }

        int result = INF;
        for (int d = 0; d < 4; d++) {
            result = Math.min(result, minCost[size - 1][size - 1][d]);
        }
        
        return result;
    }
}