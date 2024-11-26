import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;
        int[] arr = new int[4];
        for (int test_case = 1; test_case <= T; test_case++) {
            int index = 0;
            int money = Integer.parseInt(br.readLine());
            arr[index++] = money / quarter;
            money %= quarter;

            arr[index++] = money / dime;
            money %= dime;

            arr[index++] = money / nickel;
            money %= nickel;
            
            arr[index++] = money / penny;
            money %= penny;

            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();

        }


    }
    }