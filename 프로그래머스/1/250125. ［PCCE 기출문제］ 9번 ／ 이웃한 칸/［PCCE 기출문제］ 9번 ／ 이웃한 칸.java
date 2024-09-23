class Solution {
    public int solution(String[][] board, int h, int w) {
       int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        int n = board.length;
        int answer = 0;
        for(int i = 0; i <= 3; i++){
            int dh_check = h + dh[i];
            int dw_check = w + dw[i];

            if(dh_check < 0 || dh_check >= n || dw_check < 0 || dw_check >= n){
                continue;
            }

            if(board[h][w].equals(board[dh_check][dw_check])){
                answer++;
            }
        }
        return answer;
    }
}