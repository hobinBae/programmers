import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int answer = 0;
        ArrayList<Integer>[] graph = new ArrayList[V + 1];
        boolean[] visited = new boolean[V + 1];
        for(int i = 1; i <= V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= V; i++){
            if(visited[i]){
                continue;
            }
            answer++;
            ArrayDeque<Integer> dq = new ArrayDeque<>();

            dq.add(i);
            visited[i] = true;

            while (!dq.isEmpty()) {
                int now = dq.poll();
                for (int j : graph[now]) {
                    if(visited[j]){
                        continue;
                    }
                    dq.add(j);
                    visited[j] = true;
                }
            }


        }
        System.out.println(answer);

    }
}
