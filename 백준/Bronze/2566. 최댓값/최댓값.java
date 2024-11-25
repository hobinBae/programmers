import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 9;
        int[][] arr = new int[N][N];
        int max = Integer.MIN_VALUE;
        int r = 0;
        int c = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (max == arr[i][j]) {
                    r = i + 1;
                    c = j + 1;
                    break;
                }
            }
        }
        System.out.println(max);
        System.out.println(r + " " + c);
    }



}