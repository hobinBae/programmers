import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int INF = (int) 1e9;
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] costs = new int[N];
        int[] peoples = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            peoples[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[C + 101];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int i = 0 ; i < N; i++){
            for(int j = peoples[i]; j < C + 101; j++){
                dp[j] = Math.min(dp[j], costs[i] + dp[j - peoples[i]]);
            }
        }

        int answer = INF;
        for(int i = C; i < dp.length; i++){
            answer = Math.min(dp[i], answer);
        }

        System.out.println(answer);
    }
}
