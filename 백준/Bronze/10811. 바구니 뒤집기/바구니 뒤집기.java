import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = i + 1;
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            for(int j = start; j <= end; j++, end--){
                int tmp = 0;
                tmp = arr[j];
                arr[j] = arr[end];
                arr[end] = tmp;
            }
        }
        
        for(int i : arr){
            System.out.print(i + " ");
        }

    }
}