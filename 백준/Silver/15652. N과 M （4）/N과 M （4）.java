import java.util.*;
import java.io.*;

public class Main {

    static int N ;
    static int M ;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         arr = new int[N];
         back(1, 0);

        }

        private static void back(int idx, int depth){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
            for (int i = idx; i <= N; i++) {
                arr[depth] = i;
                back(i, depth + 1);
            }
        }


}