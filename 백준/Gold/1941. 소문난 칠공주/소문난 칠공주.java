import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static int N;
    static int answer;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;
        map = new char[N][N];
       boolean[][] visited = new boolean[N][N];
        answer = 0;
        for(int i = 0 ; i < N; i++){
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                map[i][j] = ch[j];
            }
        }
        boolean[] check = new boolean[7];
        int[] selected = new int[7];
        back(0, 0, check, selected);
        System.out.println(answer);

    }

    static void back(int cnt, int start, boolean[] check, int[] selected) {
        if(cnt == 7){
            int sCount = 0;
            for (boolean b : check) {
                if(b){
                    sCount++;
                }
            }
            if(isConnected(selected) && sCount >= 4){
                answer++;
                return;
            }else{
                return;
            }
        }
        for(int idx = start; idx < 25; idx++){
            int i = idx / 5;
            int j = idx % 5;

            selected[cnt] = idx;
            if (map[i][j] == 'S') {
                check[cnt] = true;
            }

            back(cnt + 1, idx + 1, check, selected);
            check[cnt] = false;

        }

    }

    static boolean isConnected(int[] selected){
        boolean[][] pick = new boolean[5][5];
        boolean[][] visited = new boolean[5][5];
        for (int s : selected) {
            int i = s / 5;
            int j = s % 5;
            pick[i][j] = true;
        }
        int y = selected[0] / 5;
        int x = selected[0] % 5;

        ArrayDeque<int[]> dq = new ArrayDeque<>();

        dq.add(new int[]{y, x});
        visited[y][x] = true;
        int count = 1;
        while (!dq.isEmpty()) {
            int[] now = dq.poll();

            for(int i = 0; i < 4; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) {
                    continue;
                }

                if (visited[ny][nx]) {
                    continue;
                }

                if(!pick[ny][nx]){
                    continue;
                }

                visited[ny][nx] = true;

                count++;

                dq.add(new int[]{ny, nx});
            }
        }
        return count == 7;
    }


}
