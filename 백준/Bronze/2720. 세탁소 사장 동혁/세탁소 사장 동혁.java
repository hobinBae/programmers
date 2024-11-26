import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        double quarter = 0.25 * 100;
        double dime = 0.10 * 100;
        double nickel = 0.05 * 100;
        double penny = 0.01 * 100;
        int[] arr = new int[4];
        for (int test_case = 1; test_case <= T; test_case++) {
            int index = 0;
            int money = Integer.parseInt(br.readLine());
           

            arr[index++] =(int)(money / quarter);
            money %= quarter;

            arr[index++] = (int) (money / dime);
            money %= dime;

            arr[index++] = (int) (money / nickel);
            money %= nickel;
            
            arr[index++] = (int) (money / penny);
            money %= penny;

            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();

        }


    }
    }