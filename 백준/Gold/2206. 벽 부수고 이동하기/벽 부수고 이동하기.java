import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int y;
        int x;
        int d;

        public Node(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 1 && M == 1) {
            System.out.println(1);
            return;

        }
        int[][] map = new int[N][M];
        int[][] dist = new int[N][M];
        boolean[][][] visited = new boolean[N][M][2];

        ArrayDeque<Node> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(ch[j]);
            }
        }

        dq.add(new Node(0, 0, 0));
        dist[0][0] = 1;
        visited[0][0][0] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }

                if (map[ny][nx] == 1) {
                    if (!visited[ny][nx][1] && now.d == 0) {

                        visited[ny][nx][1] = true;
                        dist[ny][nx] = dist[now.y][now.x] + 1;
                        dq.add(new Node(ny, nx, 1));
                    }
                } else {
                    if (visited[ny][nx][now.d]) {
                        continue;
                    }

                    visited[ny][nx][now.d] = true;
                    dist[ny][nx] = dist[now.y][now.x] + 1;
                    dq.add(new Node(ny, nx, now.d));
                }

                if (ny == N - 1 && nx == M - 1) {
                    System.out.println(dist[N - 1][M - 1]);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}
