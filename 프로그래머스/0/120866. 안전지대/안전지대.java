class Solution {
    public int solution(int[][] board) {
          int[][] move = {
                  {-1, -1},
                  {-1, 0},
                  {-1, 1},
                  {0, -1},
                  {0, 0},
                  {0, 1},
                  {1, -1},
                  {1, 0},
                  {1, 1}
        };
        boolean[][] area = new boolean[board.length][board.length];

        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 1){
                    for(int[] k : move){
                        int a = i + k[0];
                        int b = j + k[1];
                        if(a >= 0 && a < board.length && b >= 0 && b < board.length){
                            area[a][b] = true;
                        }
                    }
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < area.length; i++){
            for(int j = 0; j < area.length; j++){
                if(area[i][j]){
                  sum++;
                }
            }
        }

        return board.length * board.length - sum;
    }
}
