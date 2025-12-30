import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= test_case; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[V + 1];
            int[] dist = new int[V + 1];
            for(int i = 1; i <= V; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            boolean end = false;
            for(int i = 1; i <= V; i++){
                if(dist[i] != 0){
                    continue;
                }
                ArrayDeque<Integer> dq = new ArrayDeque<>();
                dq.add(i);
                dist[i] = 1;

                while (!dq.isEmpty()) {
                    int now = dq.poll();

                    for (int j : graph[now]) {
                        if(dist[j] == 0){
                            dist[j] = dist[now] == 1 ? -1 : 1;
                            dq.add(j);
                        }

                        else{
                            if (dist[now] == dist[j]) {
                                sb.append("NO").append("\n");
                                end = true;
                                break;
                            }
                        }
                    }
                    if(end){
                        break;
                    }
                }
                if(end){
                    break;
                }

            }
            if(!end){
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb);
    }
}
