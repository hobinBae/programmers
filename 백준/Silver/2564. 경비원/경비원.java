import java.util.*;
import java.io.*;

public class Main {
    static int x;
    static int y;
    static int[][] map;
    static int[][] store;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        map = new int[y + 1][x + 1];
        int answer = 0;
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[0].length - 1; j++) {
                map[i][j] = -1;
            }
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String d = st.nextToken();
            int idx = Integer.parseInt(st.nextToken());
            if (d.equals("1")) {
                map[0][idx] = 1;
            } else if (d.equals("2")) {
                map[y][idx] = 1;
            } else if (d.equals("3")) {
                map[idx][0] = 1;
            } else if (d.equals("4")) {
                map[idx][x] = 1;
            }
        }
        st = new StringTokenizer(br.readLine());
        String d = st.nextToken();
        int idx = Integer.parseInt(st.nextToken());
        if (d.equals("1")) {
            map[0][idx] = 2;
        } else if (d.equals("2")) {
            map[y][idx] = 2;
        } else if (d.equals("3")) {
            map[idx][0] = 2;
        } else if (d.equals("4")) {
            map[idx][x] = 2;
        }

        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                if (map[i][j] == 1) {
                    answer += minCheck(i, j);

                }
            }
        }

        System.out.println(answer);
    }

    private static int minCheck(int i, int j) {
        int min = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[y + 1][x + 1];
        visited[i][j] = true;
        int row = i;
        int col = j;
        int sum = 0;
        boolean pass = false;
        while (true) {
            for (int k = 0; k < 4; k++) {
                int nr = row + dy[k];
                int nc = col + dx[k];
                if (nr > y || nc > x || nr < 0 || nc < 0 || map[nr][nc] == -1) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                sum++;
                if (map[nr][nc] == 2) {
                    pass = true;
                    continue;
                }
                visited[nr][nc] = true;
                row = nr;
                col = nc;

            }
            if (pass) {
                break;
            }
        }
        pass = false;
        min = Math.min(min, sum);
        sum = 0;
        row = i;
        col = j;

        while (true) {
            for (int k = 0; k < 4; k++) {
                int nr = row + dy[k];
                int nc = col + dx[k];
                if (nr > y || nc > x || nr < 0 || nc < 0 || map[nr][nc] == -1) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                sum++;
                if (map[nr][nc] == 2) {
                    pass = true;
                    continue;
                }
                visited[nr][nc] = true;
                row = nr;
                col = nc;

            }
            if (pass) {
                break;
            }
        }
        min = Math.min(min, sum);
        return min;
    }
}