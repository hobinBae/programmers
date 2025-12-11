import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }
    static char[][] map;
    static int R;
    static int C;
    static int time;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        ArrayDeque<Node> fDq = new ArrayDeque<>();
        ArrayDeque<Node> jDq = new ArrayDeque<>();
        time = 0;

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < R; i++){
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                map[i][j] = ch[j];
                if(map[i][j] == 'J'){
                    jDq.add(new Node(i, j));
                    visited[i][j] = true;

                }else if(map[i][j] == 'F'){
                    fDq.add(new Node(i, j));
                }
            }
        }

        while(!jDq.isEmpty()){

            int fireSize = fDq.size();
            for(int i = 0; i < fireSize; i++){
                Node now = fDq.poll();

                for(int j = 0; j < 4; j++){
                    int ny = now.y + dy[j];
                    int nx = now.x + dx[j];

                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                        continue;
                    }


                    if(map[ny][nx] == '#'){
                        continue;
                    }
                    if(map[ny][nx] == 'F'){
                        continue;
                    }

                    map[ny][nx] = 'F';


                    fDq.add(new Node(ny, nx));
                }
            }



            int jihunSize = jDq.size();


            for(int i = 0; i < jihunSize; i++){
                Node now = jDq.poll();

                for(int j = 0; j < 4; j++){
                    int ny = now.y + dy[j];
                    int nx = now.x + dx[j];

                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                        System.out.println(time + 1);
                        return;
                    }



                    if (map[ny][nx] == 'F' || map[ny][nx] == '#') {
                        continue;
                    }

                    if(visited[ny][nx]){
                        continue;
                    }

                    visited[ny][nx] = true;

                    jDq.add(new Node(ny, nx));

                }
            }

            time++;
        }

        System.out.println("IMPOSSIBLE");



    }
}
