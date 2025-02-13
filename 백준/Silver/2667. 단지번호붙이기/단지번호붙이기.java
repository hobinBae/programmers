import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static ArrayDeque<Node> que;
    static boolean[][] visited;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        que = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        int sum = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    que.addLast(new Node(i, j));
                    visited[i][j] = true;
                    sum++;
                    list.add(bfs());
                }
            }
        }
        Collections.sort(list);
        System.out.println(sum);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
    private static int bfs(){
        int sum = 1;
        while(!que.isEmpty()){
            Node now = que.pollFirst();
            for(int i = 0; i < 4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if(nr >= N || nc >= N || nr < 0 || nc < 0){
                    continue;
                }

                if(visited[nr][nc]){
                    continue;
                }

                if(arr[nr][nc] == 1){
                    sum++;
                    que.addLast(new Node(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
        return sum;
    }
}