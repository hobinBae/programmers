import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 1;
        int i = 1;
        int answer = 1;

        while (true) {
            if(sum >= N){
                break;
            }
            sum += 6 * i++;
            answer++;
        }
        System.out.println(answer);


    }
}