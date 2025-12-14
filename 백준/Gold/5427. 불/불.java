import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < tc; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = 1;
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] map = new char[h][w];
            boolean[][] visited = new boolean[h][w];
            ArrayDeque<Node> fire = new ArrayDeque<>();

            ArrayDeque<Node> person = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    map[i][j] = ch[j];

                    if (map[i][j] == '*') {
                        fire.add(new Node(i, j));
                    }

                    if (map[i][j] == '@') {
                        person.add(new Node(i, j));
                        visited[i][j] = true;
                    }
                }
            }
            boolean end = false;
            while (!person.isEmpty()) {
                int fireSize = fire.size();

                for (int i = 0; i < fireSize; i++) {
                    Node now = fire.poll();

                    for (int j = 0; j < 4; j++) {
                        int ny = now.y + dy[j];
                        int nx = now.x + dx[j];

                        if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
                            continue;
                        }

                        if (map[ny][nx] == '#' || map[ny][nx] == '*') {
                            continue;
                        }

                        map[ny][nx] = '*';

                        fire.add(new Node(ny, nx));
                    }
                }

                int personSize = person.size();
                for (int i = 0; i < personSize; i++) {
                    Node now = person.poll();

                    for (int j = 0; j < 4; j++) {
                        int ny = now.y + dy[j];
                        int nx = now.x + dx[j];

                        if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
                            end = true;
                            break;
                        }

                        if (map[ny][nx] == '#' || map[ny][nx] == '*') {
                            continue;
                        }

                        if (visited[ny][nx]) {
                            continue;
                        }
                        visited[ny][nx] = true;
                        person.add(new Node(ny, nx));
                    }
                }
                if(end){
                    break;
                }
                answer++;

            }
            if(end){
                sb.append(answer).append("\n");
            }else{
                sb.append("IMPOSSIBLE").append("\n");
            }


        }
        System.out.println(sb);


    }
}
