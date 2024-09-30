import java.util.*;
class Solution {
    
        private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
        private static final int[] rx = {0, 0, -1, 1};
    private static final int[] ry = {-1, 1, 0, 0};

    public int solution(int[][] maps) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        int N = maps.length;
        int M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];
        queue.addLast(new Node(0, 0));
        visited[0][0] = true;
        dist[0][0] = 1;

        while(!queue.isEmpty()){
            Node now = queue.pollFirst();

            for(int i = 0; i < 4; i++){
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;
                if(maps[nr][nc] == 0)
                    continue;
                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }
        return dist[N -1][M - 1] > 0 ? dist[N -1][M - 1]   : -1;
    }
}