import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            int[] arr = {a, b, c};

            Arrays.sort(arr);

            if (arr[2] < arr[0] + arr[1]) {
                for (int i : arr) {
                    set.add(i);
                }
                int size = set.size();

                if (size == 1) {
                    System.out.println("Equilateral");

                } else if (size == 2) {
                    System.out.println("Isosceles");

                }else{
                    System.out.println("Scalene");
                }
            }else{
                System.out.println("Invalid");
            }


        }

    }
}