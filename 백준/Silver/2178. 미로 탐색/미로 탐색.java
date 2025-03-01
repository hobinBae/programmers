import java.util.*;
import java.io.*;
public class Main {
    static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int N;
    static int M;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];
        ArrayDeque<Node> que = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            String[] s = br.readLine().split("");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
    
        dist[0][0] = 1;
        visited[0][0] = true;
        que.addLast(new Node(0, 0));

        while(!que.isEmpty()){
            Node now = que.pollFirst();
            int row = now.y;
            int col = now.x;
            for(int i = 0; i < 4; i++){
                int nr = row + dy[i];
                int nc = col + dx[i];
                if(nr >= N || nc >= M || nr < 0 || nc < 0){
                    continue;
                }
                if(map[nr][nc] == 1){
                    if(!visited[nr][nc] ){
                        visited[nr][nc] = true;

                        que.addLast(new Node(nr, nc));
                        dist[nr][nc] = dist[row][col] + 1;
                    }
                }

            }
        }
     
        System.out.println(dist[N - 1][M - 1]);
    }
}