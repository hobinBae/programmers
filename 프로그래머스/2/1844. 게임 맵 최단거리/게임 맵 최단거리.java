import java.util.*;
class Solution {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;     
        }
    }
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0 };
    
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(0, 0));
        visited[0][0] = true;
        dist[0][0] = 1;

        
        while(!dq.isEmpty()){
            Node now = dq.pollFirst();
            
            for(int i = 0; i < 4; i++){
                int nextRow = now.x + dr[i];
                int nextCol = now.y + dc[i];
                
                if(nextRow >= N || nextCol >= M || nextRow < 0 || nextCol < 0){
                    continue;
                }
                
                
                if(maps[nextRow][nextCol] == 0){
                    continue;
                }
                if(!visited[nextRow][nextCol]){
                visited[nextRow][nextCol] = true;
                dq.addLast(new Node(nextRow, nextCol));
                dist[nextRow][nextCol] = dist[now.x][now.y] + 1;
                }
            }
        }
        
      return dist[N - 1][M - 1 ] == 0 ? -1 : dist[N-1][M-1];
        
    }
}