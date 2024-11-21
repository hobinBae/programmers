import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        double[] arr = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, (int)arr[i]);
        }
        for (int i = 0; i < N; i++) {
            arr[i] = arr[i] / max * 100;
        }
         double sum = 0;
        for (double v : arr) {
            sum += v;
        }
        System.out.println(sum / N);
    }
}