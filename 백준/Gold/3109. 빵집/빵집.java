import java.io.*;
import java.util.*;
public class Main {
    static int R;
    static int C;
    static char[][] map;
    static int answer;
    static int[] dy = {-1, 0, 1};
    static int[] dx = {1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        answer = 0;
        map = new char[R][C];
        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < R; i++){
            if(dfs(i, 0)){
                answer++;
            }
        }
        System.out.println(answer);

    }

    static boolean dfs(int row, int col){
        for(int i = 0; i < 3; i++){
            int nr = row + dy[i];
            int nc = col + dx[i];

            if(nr >= R || nc >= C || nc < 0 || nr < 0){
                continue;
            }

            if(map[nr][nc] == '.') {
                map[nr][nc] = 'X';
                if (nc == C - 1) {
                    return true;
                }
                if (dfs(nr, nc)) {
                    return true;
                }
            }
        }
        return false;

    }


}