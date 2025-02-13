import java.util.*;
import java.io.*;
public class Main {
	static class Node{
		int r;
		int c;
		public Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int N;
	static int M;
	static int[][]	arr;
	static int[][] cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cnt = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				cnt[i][j] = -1;
			}
		}
		cnt[N - 1][M - 1] = 1;
		 bfs(new Node(0, 0));
		System.out.println(cnt[0][0]);
		
	}
	
	private static int bfs(Node now) {
		if(cnt[now.r][now.c] > -1) {
			return cnt[now.r][now.c];
		}
		
		cnt[now.r][now.c] = 0;
		
		for(int i = 0; i < 4; i++) {
			int nr = now.r + dr[i];
			int nc = now.c + dc[i];
			
			if(nr >= N || nc >= M || nr < 0 || nc < 0) {
				continue;
			}
			
			if(arr[nr][nc] < arr[now.r][now.c]) {
				cnt[now.r][now.c] += bfs(new Node(nr, nc));
				
			}
		}
		return cnt[now.r][now.c];
	}
	

}