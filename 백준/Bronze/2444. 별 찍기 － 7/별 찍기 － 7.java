import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N - i -1 ; j++){
                System.out.print(" ");
            }
            for(int k = N - 1 - i; k < N + i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = N - 2; i >= 0; i--){
            for(int k = 0; k < N - 1 - i; k++){
                System.out.print(" ");
            }

            for(int j = N - 1 - i; j < N + i; j++){
                System.out.print("*");
            }


            System.out.println();
        }


    }
}