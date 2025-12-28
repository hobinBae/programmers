import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int V;
    static int E;
    static int start;
    static ArrayList<Integer>[] graph;
    static StringBuilder bfsOutput = new StringBuilder();
    static StringBuilder dfsOutput = new StringBuilder();
    static boolean[] bfsVisited;
    static boolean[] dfsVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 1];
        bfsVisited = new boolean[V + 1];
        dfsVisited = new boolean[V + 1];
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
            Collections.sort(graph[i]);
        }
        dfs(start);
        bfs(start);

        System.out.println(dfsOutput);
        System.out.println(bfsOutput);
    }

    static void dfs(int start){
        dfsVisited[start] = true;
        dfsOutput.append(start).append(" ");
        for (int i : graph[start]) {
            if (dfsVisited[i]) {
                continue;
            }

            dfsVisited[i] = true;
            dfs(i);
        }
    }

    static void bfs(int start){
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(start);

        bfsVisited[start] = true;

        while (!dq.isEmpty()) {
            int now = dq.poll();
            bfsOutput.append(now).append(" ");
            for (int i : graph[now]) {
                if (bfsVisited[i]) {
                    continue;
                }
                dq.add(i);
                bfsVisited[i] = true;
            }
        }

    }
}
