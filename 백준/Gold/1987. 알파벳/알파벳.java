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
    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};
    private static int N;
    private static int M;
    private static boolean[] used;
    private static int answer;
    private static char[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new boolean['Z' - 'A' + 1];
        map = new char[N][M];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }
        used[map[0][0] - 'A'] = true;
        backtrack(new Node(0, 0) , 1);

        System.out.println(answer);
    }

    private static void backtrack(Node now , int cnt){
        answer = Math.max(answer, cnt);
        for(int i = 0; i < 4; i++){
            int nr = now.r + dr[i];
            int nc = now.c + dc[i];
            if (nr >= N || nc >= M || nr < 0 || nc < 0) {
                continue;
            }

            if (used[map[nr][nc] - 'A']) {
                continue;
            }
            used[map[nr][nc] - 'A'] = true;
            backtrack(new Node(nr, nc) , cnt + 1);
            used[map[nr][nc] - 'A'] = false;
        }
    }
}