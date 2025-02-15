import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int big = 1;
        int small = 1;
        int bigMax = 0;
        int smallMax = 0;

        for(int i = 1; i < N; i++){
            if(arr[i - 1] < arr[i]){
                big++;
                smallMax = Math.max(smallMax, small);
                small = 1;
            }else if(arr[i - 1] > arr[i]){
                small++;
                bigMax = Math.max(bigMax, big);
                big = 1;
            }else{
                small++;
                big++;
            }
            bigMax = Math.max(big, bigMax);
            smallMax = Math.max(small, smallMax);
        }
        if(N == 1){
            System.out.println(1);
        }else{
            int answer = Math.max(bigMax, smallMax);
            System.out.println(answer);
        }

    }
}