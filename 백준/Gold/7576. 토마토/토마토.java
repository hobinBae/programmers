import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    // 처음 저장된 상태에 모두 익은 상태라면 0
    // 모두 익지 못하는 상황이라면 -1
    // 토마토가 모두 익을 때까지의 최소 날짜를 출력
    // 익은 토마토 상하좌우가 안익은 토마토에게 영향을 줌
    // 토마토는 혼자 익을 수 없음

    // -1인 구역은 없는 토마토니까 갈 수 없음 1은 이미 익은 토마토니까 안감
    //

    static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayDeque<Node> dq = new ArrayDeque<>();

        answer = 0;
        int[][] map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    dq.addLast(new Node(i, j));
                }
            }
        }

        while (!dq.isEmpty()) {
            Node now = dq.pollFirst();

            for(int i = 0; i < 4; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }


                if(map[ny][nx] != 0){
                    continue;
                }

                map[ny][nx] = map[now.y][now.x] + 1;

                dq.addLast(new Node(ny, nx));
            }
        }

        for(int[] arr : map){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == 0){
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(arr[i], answer);

            }
        }

        System.out.println(answer - 1);


    }
}
