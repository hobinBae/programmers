import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static boolean[][] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
         M = Integer.parseInt(br.readLine());
         check = new boolean[N][N];
         for(int i = 0; i < M; i++){
             StringTokenizer st = new StringTokenizer(br.readLine());
             int a = Integer.parseInt(st.nextToken()) - 1;
             int b = Integer.parseInt(st.nextToken()) - 1;
             check[a][b] = true;
         }
         int[] cnt = new int[N];

        floyd();
         for(int i = 0; i < N; i++){
             for(int j = 0; j < N; j++){
                 if(check[i][j] || check[j][i]){
                     cnt[i]++;
                 }
             }
         }

        for (int i : cnt) {
            int answer = (N - 1) - i;
            System.out.println(answer);
        }


    }
    static void floyd(){
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if (check[i][k] && check[k][j]) {
                        check[i][j] = true;
                    }
                }
            }
        }
    }
}