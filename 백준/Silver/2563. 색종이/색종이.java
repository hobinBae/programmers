import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = 100;
        int[][] arr = new int[N][N];
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());


            for(int i = row; i < row + 10; i++){
                for(int j = col; j < col + 10; j++){
                    arr[i][j]++;
                }
            }

        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] > 1) {
                    sum += arr[i][j] - 1;
                }
            }
        }
            int answer = T * 100 - sum;
            System.out.println(answer);
        }
    }