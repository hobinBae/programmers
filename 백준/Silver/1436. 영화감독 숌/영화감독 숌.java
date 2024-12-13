import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i = 0;
        int sum = 0;
        while (sum < N) {
            i++;
            String s = i + "";
            if (s.contains("666")) {
                sum++;
            }
        }
        System.out.println(i);

    }
}