import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        if(N == 0){
            System.out.println(1);
            return;
        }

        int[] ranking = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            ranking[i] = Integer.parseInt(st.nextToken());
        }

        if (N == P && ranking[N - 1] >= score) {
            System.out.println(-1);
            return;
        }
        int rank = 1;
        
        for(int i = 0; i < N; i++){
            if (ranking[i] > score) {
                rank++;
            }else{
                break;
            }
        }
        System.out.println(rank);
    }
}
