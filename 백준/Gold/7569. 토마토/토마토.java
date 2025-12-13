import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static class Node {
        int x;
        int y;
        int h;
        public Node(int y, int x, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] map = new int[N * H][M];
        int[][] dist = new int[N * H][M];

        ArrayDeque<Node> dq = new ArrayDeque<>();

        for(int k = 0; k < H; k++){
            for(int i = N * k; i < N + N * k; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1){
                        dq.add(new Node(i, j, k + 1));
                        dist[i][j] = 1;
                    }
                    if(map[i][j] == -1){
                        dist[i][j] = 1;
                    }

                }
            }
        }

        while(!dq.isEmpty()){
            Node now = dq.poll();

            for(int i = 0; i < 4; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                int nf = now.y - N;
                int df = now.y + N;

                if(ny < N * (now.h - 1) || nx < 0 || ny >= N * now.h || nx >= M){
                    continue;
                }

                if(nf >= 0){
                    if(map[nf][now.x] == 0){
                        map[nf][now.x] = 1;
                        dist[nf][now.x] = dist[now.y][now.x] + 1;
                        dq.add(new Node(nf, now.x, now.h - 1));
                    }
                }

                if(df < map.length){
                    if(map[df][now.x] == 0){
                        map[df][now.x] = 1;
                        dist[df][now.x] = dist[now.y][now.x] + 1;
                        dq.add(new Node(df, now.x, now.h + 1));
                    }

                }

                if(map[ny][nx] == 0){
                    map[ny][nx] = 1;
                    dist[ny][nx] = dist[now.y][now.x] + 1;
                    dq.add(new Node(ny, nx, now.h));
                }
            }

        }
        int answer = Integer.MIN_VALUE;

        for (int[] time : dist) {
            for(int i = 0; i < time.length; i++){
                if (time[i] == 0) {
                    System.out.println(-1);
                    return;
                }

                answer = Math.max(time[i], answer);
            }
        }
        System.out.println(answer - 1);

    }
}
