import java.util.*;
import java.io.*;
public class Main {
    static int R;
    static int C;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static char[][] map;
    static int answer;
    static boolean[] used;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        used = new boolean['Z' - 'A' + 1];
        for(int i = 0; i < R; i++){
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                map[i][j] = ch[j];
            }
        }

        used[map[0][0] - 'A'] = true;
        answer = 0;
        dfs(0, 0, 1);
        System.out.println(answer);
    }
    static void dfs(int row, int col, int sum){
        answer = Math.max(sum, answer);
        for(int i = 0; i < 4; i++){
            int nr = row + dy[i];
            int nc = col + dx[i];

            if(nr >= R || nc >= C || nr < 0 || nc < 0){
                continue;
            }

            if(!used[map[nr][nc] - 'A']){
                used[map[nr][nc] - 'A'] = true;
                dfs(nr, nc, sum + 1);
                used[map[nr][nc] - 'A'] = false;
            }
        }
    }
}