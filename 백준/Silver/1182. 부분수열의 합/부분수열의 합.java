import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtrack(0,    0, 0);
        System.out.println(answer);
    }
    static void backtrack(int cnt, int sum, int check){

        if(cnt == N){
            if(sum == M && check > 0)
                answer++;
            return;
        }

            backtrack(cnt + 1,  sum + arr[cnt], check + 1);
            backtrack(cnt + 1 , sum, check);


    }
}