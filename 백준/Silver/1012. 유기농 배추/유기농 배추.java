import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] arr;
    static boolean[][] visited;
    static ArrayDeque<Node> que;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            arr = new int[M][N];
            visited = new boolean[M][N];
            int answer = 0;
            que = new ArrayDeque<>(0);
            int K = Integer.parseInt(st.nextToken());
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                arr[row][col] = 1;
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        que.addLast(new Node(i, j));
                        bfs();
                        answer++;
                    }
                }
            }
            System.out.println(answer);


        }

    }
    static void bfs(){
        while(!que.isEmpty()){
            Node now = que.pollFirst();
            for(int i = 0; i < 4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if(nr >= M || nc >= N || nr < 0 || nc < 0){
                    continue;
                }
                if(visited[nr][nc]){
                   continue;
                }
                if(arr[nr][nc] == 1){
                    visited[nr][nc] = true;
                    que.addLast(new Node(nr, nc));
                }
            }
        }
    }
}