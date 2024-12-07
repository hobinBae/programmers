import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        if (a + b + c == 180) {
            set.add(a);
            set.add(b);
            set.add(c);
            int size = set.size();
            if(size == 1){
                System.out.println("Equilateral");
            }else if(size == 2){
                System.out.println("Isosceles");

            }else{
                System.out.println("Scalene");
            }
        }else{
            System.out.println("Error");
        }
    }
}