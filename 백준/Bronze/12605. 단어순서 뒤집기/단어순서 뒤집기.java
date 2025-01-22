import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] str = br.readLine().split(" ");
            Stack<String> stack = new Stack<>();
            for (String s : str) {
                stack.push(s);
            }
            System.out.print("Case #" + test_case + ": ");
            while(!stack.isEmpty()){
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }

    }
}