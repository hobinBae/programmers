import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static boolean check[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] cnt = new int[N];
        check = new boolean[N][N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            check[a][b] = true;
        }
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(check[i][k] && check[k][j]){
                        check[i][j] = true;
                    }
                }
            }
        }
//        floyd();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(check[i][j] || check[j][i]){
                    cnt[i]++;
                }
            }
        }
        int answer = 0;
        for (int i : cnt) {
            if(i == N - 1){
                answer++;
            }
        }
        System.out.println(answer);
    }

    static void floyd(){
        
    }

}