import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder one = new StringBuilder(st.nextToken());
        StringBuilder two = new StringBuilder(st.nextToken());

        int o1 = Integer.parseInt(one.reverse().toString());
        int o2 = Integer.parseInt(two.reverse().toString());

        int[] arr = {o1, o2};
        Arrays.sort(arr);
        System.out.println(arr[1]);
    }
}