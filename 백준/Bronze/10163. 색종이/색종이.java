import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[1001][1001];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startCol = Integer.parseInt(st.nextToken());
            int startRow = Integer.parseInt(st.nextToken());

            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for(int j = startRow + height - 1; j >= startRow; j--){
                for(int k = startCol; k < startCol + width; k++){
                    arr[j][k] = i;
                }
            }
        }

        for(int i = 1; i <= N; i++){
            int sum = 0;
            for(int j = 0; j < arr.length; j++){
                for(int k = 0; k < arr.length; k++){
                    if(arr[j][k] == i){
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }



    }
}