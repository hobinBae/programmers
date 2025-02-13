import java.util.*;
import java.io.*;
public class Main {
    static int[][] arr;
    static int N;
    static int sum;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int network = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        for(int i = 0; i < network; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[b][a] = 1;
            arr[a][b] = 1;
        }

        dfs(0);
        sum--;
        System.out.println(sum);
     
    }
    private static void dfs(int now){
        if(visited[now]){
            return;
        }
        sum++;
        visited[now] = true;
        for(int i = 0; i < N; i++){
            if(arr[now][i] == 1){
                dfs(i);
            }
        }
    }
}