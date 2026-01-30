import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Cctv {
        int y;
        int x;
        int type;

        public Cctv(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    static int N;
    static int M;
    static int[][] map;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static ArrayList<Cctv> cctvList;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cctvList = new ArrayList<>();

        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6) {
                    cctvList.add(new Cctv(i, j, map[i][j]));
                }
            }
        }

        backtrack(0);
        System.out.println(answer);


    }

    static void backtrack(int cnt){
//        System.out.println(list.size());
        if(cnt == cctvList.size()){
            //사각지대 수를 세야함
            int area = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 0){
                        area++;
                    }
                }
            }
//            System.out.println(area);
            answer = Math.min(answer, area);
            return;
        }

        Cctv cctv = cctvList.get(cnt);
//        System.out.println(cctv.type);
        switch (cctv.type){
            case 1 :
                watchType1(cctv.y, cctv.x, cnt);
                break;
            case 2 :
                watchType2(cctv.y, cctv.x, cnt);
                break;
            case 3 :
                watchType3(cctv.y, cctv.x, cnt);
                break;
            case 4 :
                watchType4(cctv.y, cctv.x, cnt);
                break;
            case 5 :
                watchType5(cctv.y, cctv.x, cnt);
                break;

        }


    }

    static void watchType1(int y, int x, int index){

        for(int i = 0; i < 4; i++){
            List<int[]> list = new ArrayList<>();
            //이거는 한 방향을 갈 때마다 백트래킹 호출
            watch(y, x, i, list);
            // 여기서 리스트의 다음 원소를 호출 해줘야함
            backtrack(index + 1);

            recovery(list);
        }

    }

    static void watchType2(int y, int x, int index){

        for(int i = 0; i < 4; i++){
            List<int[]> list = new ArrayList<>();
            // ^ 연산을 하면 편해짐
            //0 -> 1, 2 -> 3
            watch(y, x, i, list);
            watch(y, x, i ^ 1, list);

            // 여기서 호출을 해줘야하는데
            backtrack(index + 1);

            recovery(list);

        }


    }

    static void watchType3(int y, int x, int index){
        for(int i = 0; i < 2; i++){
            for(int j = 2; j < 4; j++){
                List<int[]> list = new ArrayList<>();
                //예는 2, 3으로 가야함
                watch(y, x, i, list);
                watch(y, x, j, list);

                // 여기서 호출
                backtrack(index + 1);

                recovery(list);

            }
        }
    }

    static void watchType4(int y, int x, int index){

        for(int i = 0; i < 4; i++){
            List<int[]> list = new ArrayList<>();
            for(int j = 0; j < 4; j++){
                //하나씩만 제외하면 됨
                if(j == i){
                    continue;
                }
                watch(y, x, j, list);
            }
            backtrack(index + 1);
            recovery(list);
            //여기서 호출
        }

    }

    static void watchType5(int y, int x, int index){
        //얘는 그냥 4방향 다 가면 됨
            List<int[]> list = new ArrayList<>();
            for(int j = 0; j < 4; j++){
                watch(y, x, j, list);
            }
            backtrack(index + 1);
            recovery(list);


    }

    static void watch(int y, int x, int dir, List<int[]> list){
        //cctv 또는 벽(6) 또는 밖으로 나가는 경우는 멈춤
        while(true){
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                return;
            }

            if (map[ny][nx] == 6) {
                return;
            }
            if(map[ny][nx] > 0 && map[ny][nx] < 6 || map[ny][nx] == 7){
                y = ny;
                x = nx;
                continue;
            }
            map[ny][nx] = 7;
            list.add(new int[]{ny, nx});

            y = ny;
            x = nx;
        }
    }
    static void recovery( List<int[]> list){
        for(int i = 0; i < list.size(); i++){
            int[] now = list.get(i);
            map[now[0]][now[1]] = 0;
        }

    }
}
