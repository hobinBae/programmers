import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int answer = re(N, R, C);
        System.out.println(answer);

    }

    static int re(int n, int r, int c){
        if(n == 0){
            return 0;
        }

        int half = 1 << (n - 1);

        // 1사분면
        if(r < half && c < half){
            return re(n - 1, r, c);
        }

        // 2사분면
         if(r < half && c >= half){
            return half * half + re(n - 1, r, c - half);
        }

        // 3사분면
        if(r >= half && c < half){
            return 2 * half * half + re(n - 1, r - half, c);
        }
        else{
            return 3 * half * half + re(n - 1, r - half, c - half);

        }
    }

}
