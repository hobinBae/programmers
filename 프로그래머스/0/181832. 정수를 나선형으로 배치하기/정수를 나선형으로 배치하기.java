class Solution {
    public int[][] solution(int n) {
           int[][] arr = new int[n][n];
        int row = 0, col = 0;
        int[] dRow = {0, 1, 0, -1};
        int[] dCol = {1, 0, -1, 0};
        int direction = 0;
        int num = 1;

        while(num <= n * n){
            arr[row][col] = num++;

            int nextRow = row + dRow[direction];
            int nextCol = col + dCol[direction];

            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || arr[nextRow][nextCol] != 0){
                direction = (direction + 1) % 4; 
            }
            row += dRow[direction];
            col += dCol[direction];
        }


        return arr;
    }
}