import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 5;
        int M = 15;
        String[][] arr = new String[5][15];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split("");
            for(int j = 0; j < input.length; j++){
                arr[i][j] = input[j];
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[j][i] != null){
                    sb.append(arr[j][i]);
                }
            }
        }
        System.out.println(sb.toString());

    }



}