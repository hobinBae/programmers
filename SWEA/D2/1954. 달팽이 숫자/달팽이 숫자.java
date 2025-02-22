import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};
            int[][] arr = new int[N][N];

            StringBuilder sb = new StringBuilder();
            int idx = 0;
            int row = 0;
            int col = 0;
            for(int i = 1; i <= N * N; i++){
                arr[row][col] = i;

                int nr = row + dr[idx];
                int nc = col + dc[idx];
                if (nr >= N || nc >= N || nr < 0 || nc < 0 || arr[nr][nc] != 0) {
                    idx = (idx + 1) % 4;
                    nr = row + dr[idx];
                    nc = col + dc[idx];
                }
                row = nr;
                col = nc;
            }
//            while(true){
//                int nr = row + dr[idx % dr.length];
//                int nc = col + dc[idx % dc.length];
//
//                if (nr >= N || nc >= N || nr < 0 || nc < 0 || visited[nr][nc]) {
//                    idx++;
//
//                }else{
//                    visited[nr][nc] = true;
//                    row = nr;
//                    col = nc;
//                    arr[nr][nc] = sum++;
//
//                }
//                if (sum > N * N) {
//                    break;
//                }
//
//            }
            sb.append("#").append(t).append("\n");
           for(int i = 0; i < N; i++){
               for(int j = 0; j < N; j++){
                   sb.append(arr[i][j]).append(" ");
               }
               sb.append("\n");
           }
            System.out.print(sb);

        }
    }
}