import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
 Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int move : moves){
            int col = move - 1;
            int row = 0;

            while(row < board.length && board[row][col] == 0){
                row++;
            }

            if(row < board.length && board[row][col] != 0){
                if(!stack.isEmpty() && stack.peek() == board[row][col]){
                    stack.pop();
                    answer += 2;
                }else{
                    stack.push(board[row][col]);
                }
                board[row][col] = 0;
            }

        }
        return answer;
        
    }
}