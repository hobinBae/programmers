import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int K = Integer.parseInt(st.nextToken());
            for(int j = start; j <= end; j++){
                arr[j] = K;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}