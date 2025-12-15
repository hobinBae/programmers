import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int[][] map = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());

            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for (int j = leftY; j < rightY; j++) {
                for (int k = leftX; k < rightX; k++) {
                    map[j][k] = -1;
                }
            }

        }
        int area = 0;
        for (int i = 0; i < M ; i++) {
            for (int j = 0; j < N ; j++) {
                if (map[i][j] == 0) {
                    if (!visited[i][j]) {
                        int size = 1;
                        area++;
                        visited[i][j] = true;

                        dq.add(new int[]{i, j});

                        while (!dq.isEmpty()) {
                            int[] now = dq.poll();

                            for (int k = 0; k < 4; k++) {
                                int ny = now[0] + dy[k];
                                int nx = now[1] + dx[k];

                                if (ny < 0 || nx < 0 || ny >= M || nx >= N) {
                                    continue;
                                }
                                if (map[ny][nx] != 0) {
                                    continue;
                                }
                                if (visited[ny][nx]) {
                                    continue;
                                }

                                visited[ny][nx] = true;

                                size++;

                                dq.add(new int[]{ny, nx});
                            }
                        }
                        list.add(size);
                    }

                }


            }
        }
        System.out.println(area);
        int[] answer = list.stream().sorted().mapToInt(Integer::intValue).toArray();
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
