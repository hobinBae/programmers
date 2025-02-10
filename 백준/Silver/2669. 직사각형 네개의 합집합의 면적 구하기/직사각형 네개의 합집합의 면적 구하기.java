import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[100][100];
        for(int i = 0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for(int j = endY - 1; j >= startY; j--){
                for(int k = startX; k < endX; k++){
                    arr[j][k]++;
                }
            }
        }
        int sum = 0;
        for (int[] i : arr) {
            for (int j : i) {
                if(j > 0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}