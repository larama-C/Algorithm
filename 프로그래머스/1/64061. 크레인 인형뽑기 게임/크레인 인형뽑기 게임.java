import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        
        for(int move : moves) {
            int column = move - 1;
            
            for(int i = 0; i < board.length; i++) {
                if(board[i][column] != 0) {
                    int doll = board[i][column];
                    board[i][column] = 0;
                    
                    if(!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        answer += 2;
                    }
                    else {
                        basket.push(doll);
                    }
                    break;
                }
            }
        }
        
        
        return answer;
    }
}