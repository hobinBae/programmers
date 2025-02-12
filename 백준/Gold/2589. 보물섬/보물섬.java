import java.util.*;
import java.io.*;

public class Main {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer (br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        int max = 0;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(arr[i][j] == 'L'){
                ArrayDeque<Node> que = new ArrayDeque<>();
                boolean[][] visited = new boolean[N][M];
                int[][] dist = new int[N][M];
                visited[i][j] = true;
                que.addLast(new Node(i, j));
                while(!que.isEmpty()){
                    Node node = que.pollFirst();
                    for(int k = 0; k < 4; k++){
                        int nr = node.x + dr[k];
                        int nc = node.y + dc[k];

                        if(nr >= N || nc >= M || nr < 0 || nc < 0){
                            continue;
                        }
                        if(arr[nr][nc] == 'W'){
                            continue;
                        }
                        if(!visited[nr][nc]){
                            visited[nr][nc] = true;
                            que.addLast(new Node(nr, nc));
                            dist[nr][nc] = dist[node.x][node.y] + 1;
                            max = Math.max( dist[nr][nc], max);
                        }
                    }
                }


            }
        }
    }
        System.out.println(max);
    }
}