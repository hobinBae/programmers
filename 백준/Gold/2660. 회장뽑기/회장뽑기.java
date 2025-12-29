import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int no;
        int score;
        public Node(int no, int score) {
            this.no = no;
            this.score = score;
        }
    }
    static ArrayList<Integer>[] graph;

    static int V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];
        for(int i = 1; i <= V; i++){
            graph[i] = new ArrayList<>();
        }
        int[] score = new int[V + 1];
        int min = Integer.MAX_VALUE;

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(u == -1){
                break;
            }
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= V; i++){
            ArrayDeque<Node> dq = new ArrayDeque<>();
            int max = 0;
            boolean[] visited = new boolean[V + 1];
            dq.add(new Node(i, 0));
            visited[i] = true;

            while(!dq.isEmpty()){
                Node now = dq.poll();

                for (int j : graph[now.no]) {
                    if(visited[j]){
                        continue;
                    }

                    visited[j] = true;
                    dq.add(new Node(j, now.score + 1));
                    max = Math.max(now.score + 1, max);
                }
            }

            score[i] = max;
            min = Math.min(max,min);
        }

        ArrayList<Integer> candidate = new ArrayList<>();
        int candidateSize = 0;
        for(int i = 1; i < score.length; i++){
            if (min == score[i]) {
                candidate.add(i);
                candidateSize++;
            }
        }
        Collections.sort(candidate);
        System.out.println(min + " " + candidateSize);
        for (Integer i : candidate) {
            System.out.print(i + " ");
        }
    }
}
