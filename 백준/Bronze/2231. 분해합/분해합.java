import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int n = Integer.parseInt(N);
        int num = N.length() * 9;
        int index = n - num;
        int answer = 0;

            for (int i = index; i < n; i++) {
                int sum = 0;
                int value = i;
                while (value != 0) {
                    sum += value % 10;
                    value /= 10;
                }

                if (sum + i == n) {
                    answer = i;
                    break;
                }

            }
            System.out.println(answer);
    }
}