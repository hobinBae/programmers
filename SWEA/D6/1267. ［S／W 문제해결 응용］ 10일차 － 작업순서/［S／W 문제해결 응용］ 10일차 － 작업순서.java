

import java.util.*;
import java.io.*;

public class Solution {
    static int V;
    static int E;
    static int[] indegree;
    static ArrayList<Integer>[] graph;
    static ArrayDeque<Integer> que;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            indegree = new int[V + 1];

            graph = new ArrayList[V + 1];

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                //선행작업의 수를 증가스킵니다.
                indegree[end]++;
            }
            que = new ArrayDeque<>();

            for (int i = 1; i < V; i++) {
                if (indegree[i] == 0) {
                    que.addLast(i);
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            while (!que.isEmpty()) {

                int now = que.pollFirst();
                list.add(now);
                for (int i : graph[now]) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        que.addLast(i);
                    }
                }
            }
            sb.append("#").append(t).append(" ");
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
