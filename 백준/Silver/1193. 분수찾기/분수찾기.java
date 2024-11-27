import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int curr = 0;
        int sum = 0;
        while (true) {
            sum += ++curr;

            if (sum >= N) {
                int M = sum - N;
                if (curr % 2 == 0) {
                    System.out.println((curr - M) + "/" + (1 + M));


                } else {
                    System.out.println((1 + M) + "/" + (curr - M));
                }
                break;
            }
        }

    }
}