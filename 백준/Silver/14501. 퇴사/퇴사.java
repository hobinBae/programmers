import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] time;
    static int[] money;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
         time = new int[N];
         money = new int[N];
        max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            money[i] = Integer.parseInt(st.nextToken());
        }

        backtrack( 0, 0);
        System.out.println(max);
    }

    static void backtrack(int cnt , int sumM){
        if(cnt >= N){
            max = Math.max(sumM, max);
            return;
        }
            if(cnt + time[cnt] <= N){
                backtrack(cnt + time[cnt], sumM + money[cnt]);
            }
            backtrack(cnt + 1, sumM);

        }
    }