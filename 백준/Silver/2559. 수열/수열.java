import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
         st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for(int i = 0; i < M; i++){
            sum += arr[i];
        }

        int answer = sum;
        int left = 0;
        int right = M;

        while(right < N){
            sum -= arr[left++];
            sum += arr[right++];
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);


    }
}