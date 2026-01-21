import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int x;
        int y;
        int t;


        public Node(int y, int x, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int H;
    static int W;

    static char[][] map;

    static int[][] dist;
    static int answer;

    static int[] start;
    static int[] end;

    static int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        answer = 0;

        map = new char[H][W];
        dist = new int[H][W];
        start = new int[2];
        end = new int[2];

        for (int i = 0; i < H; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                map[i][j] = ch[j];
                if (map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }

                if (map[i][j] == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                dist[i][j] = INF;
            }
        }
        bfs();
        System.out.println(answer);


    }

    static void bfs() {
        PriorityQueue<Node> pq =
                new PriorityQueue<>((o1, o2) -> Integer.compare(o1.t, o2.t));

        pq.add(new Node(start[0], start[1], 0));
        dist[start[0]][start[1]] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.t > dist[curr.y][curr.x]) continue;

            if(curr.y == end[0] && curr.x == end[1]){
                answer = dist[curr.y][curr.x];
                return;
            }


            for(int i = 0; i < 4; i++){
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];

                if (check(ny, nx) && map[ny][nx] != '#') {
                    int time = 1;
                    if(checkWell(ny, nx) && checkWell(curr.y, curr.x)){
                        time = 0;
                    }

                    if(dist[ny][nx] > dist[curr.y][curr.x] + time){
                        dist[ny][nx] = dist[curr.y][curr.x] + time;
                        pq.add(new Node(ny, nx, dist[ny][nx]));

                    }


                }
            }


        }

    }

    static boolean checkWell(int y, int x) {
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (check(ny, nx)) {
                if (map[ny][nx] == '#') {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean check(int y, int x){
        return y >= 0 && y < H && x >= 0 && x < W;
    }
}
