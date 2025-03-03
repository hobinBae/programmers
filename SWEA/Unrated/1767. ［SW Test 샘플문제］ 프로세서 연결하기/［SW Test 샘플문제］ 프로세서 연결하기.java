import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static int[][] map;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static ArrayList<int[]> list;
    static int core;
    static int line;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            core = Integer.MIN_VALUE;
            line = Integer.MAX_VALUE;
            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (i != 0 && j != 0 && i != N - 1 && j != N - 1) {
                        if (map[i][j] == 1) {
                            list.add(new int[]{i, j});
                        }
                    }
                }
            }
            backtrack(0, 0, 0);
            sb.append("#").append(t).append(" ").append(line).append("\n");
        }
        System.out.println(sb);
    }

    static void backtrack(int index, int cnt, int length) {
        if (index == list.size()) {
            if (cnt > core) {
                core = cnt;
                line = length;
            } else if (cnt == core) {
                line = Math.min(line, length);
            }
            return;
        }
        int[] arr = list.get(index);
        int row = arr[0];
        int col = arr[1];
        for (int i = 0; i < 4; i++) {
            int nr = row;
            int nc = col;
            int lineLength = 0;
            ArrayList<int[]> path = new ArrayList<>();
            boolean connect = false;
            while (true) {
                nr += dy[i];
                nc += dx[i];
                if (nr >= N || nc >= N || nr < 0 || nc < 0 || map[nr][nc] != 0) {
                    break;
                }
                path.add(new int[]{nr, nc});
                lineLength++;
                if (nr == N - 1 || nc == N - 1 || nc == 0 || nr == 0) {
                    connect = true;
                }
            }
            if (connect) {
                for (int[] l : path) {
                    map[l[0]][l[1]] = 1;
                }
                backtrack(index + 1, cnt + 1, length + lineLength);
                for (int[] l : path) {
                    map[l[0]][l[1]] = 0;
                }
            }

        }
        backtrack(index + 1, cnt, length);
    }
}