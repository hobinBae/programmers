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
    static int N;
    static int[][] map;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 2][N + 2];

        int appleSize = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < appleSize; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = 2;
        }

        HashMap<Integer, String> move = new HashMap<>();
        int rotation = Integer.parseInt(br.readLine());
        for(int i = 0; i < rotation; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();

            move.put(x, c);
        }
        int time = 1;
        int y = 1;
        int x = 1;
        int d = 0;
        map[y][x] = 1;
        ArrayDeque<Node> snake = new ArrayDeque<>();
        snake.add(new Node(y, x));
        while(true){
//            System.out.println(time);
//            for (int[] ints : map) {
//                System.out.println(Arrays.toString(ints));
//            }
//
//
//
//
//            System.out.println();
//            System.out.println();



            int ny = y + dy[d];
            int nx = x + dx[d];

            if (move.containsKey(time)) {
                d = nextD(d, move.get(time));
            }

            if(check(ny, nx)){
//                System.out.println(time + " dk");
                break;
            }

            if(map[ny][nx] == 2){
                //사과를 먹은 로직
                map[ny][nx] = 1;
                snake.addFirst(new Node(ny, nx));
            }else{
                //일단 이동
                //여기에 이동을 한 뒤 머리 위치가 꼬리야 그럼 끝
                if(map[ny][nx] == 1){
                    break;
                }
                Node tail = snake.pollLast();
                map[tail.y][tail.x] = 0;

                map[ny][nx] = 1;
                snake.addFirst(new Node(ny, nx));
            }

            time++;
            y = ny;
            x = nx;

        }
        System.out.println(time);
    }

    static boolean check(int y, int x){
        return y < 1 || y > N || x < 1 || x > N;
    }

    static int nextD(int d, String c){
        if(c.equals("D")){
            d++;
            if(d > 3){
                d = 0;
            }
        }else{
            d--;
            if(d < 0){
                d = 3;
            }
        }
        return d;
    }
}
