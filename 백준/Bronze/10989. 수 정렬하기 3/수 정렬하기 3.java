import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());

        }
        Arrays.sort(num);
        for (int i = 0; i < N; i++) {
            sb.append(num[i]).append('\n');
        }
        System.out.println(sb);


    }
}