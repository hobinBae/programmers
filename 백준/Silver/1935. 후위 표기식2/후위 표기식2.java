import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] post = br.readLine().toCharArray();
        ArrayDeque<Double> dq = new ArrayDeque<>();
        double[] arr = new double[N];
        for(int i = 0; i < N; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }
        double sum = 0.;
        for (char c : post) {
            if (c != '*' && c != '+' && c != '-' && c != '/') {
                dq.addLast(arr[c - 'A']);
            } else {
                double a = dq.pollLast();
                double b = dq.pollLast();
                if (c == '*') {
                    sum = b * a;

                } else if (c == '+') {
                    sum = b + a;

                } else if (c == '-') {
                    sum = b - a;

                } else if (c == '/'){
                    sum = b / a;
                }
                dq.addLast(sum);
            }
        }
        System.out.printf("%.2f" , dq.poll());


    }
}
