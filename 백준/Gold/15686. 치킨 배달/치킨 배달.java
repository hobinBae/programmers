import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int M;
	static ArrayList<int[]> home;
	static ArrayList<int[]> chicken;
	static int min;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value == 1) {
					home.add(new int[] {i + 1, j + 1});
				}else if(value == 2) {
					chicken.add(new int[] {i + 1, j + 1});
				}
			}
		}
		visited = new boolean[chicken.size()];
//		backtrack(0, 0, 0);
		backtrack(0, 0);
		System.out.println(min);
	}
	
	static void backtrack(int cnt, int start) {
		if(cnt == M) {
			min = Math.min(getMinDist(), min);

		}
		
		for(int i = start; i < chicken.size(); i++) {
			
			if(!visited[i]) {
				visited[i] = true;
				backtrack(cnt + 1, i + 1);
				visited[i] = false;
			}
			
		}
		
	}
	static int getMinDist() {
		int total = 0;
		
		for(int[] i : home) {
			int distMin = Integer.MAX_VALUE;
			for(int j = 0; j < chicken.size(); j++) {
				if(visited[j]) {
					int y = chicken.get(j)[0];
					int x = chicken.get(j)[1];
					
					int dist = Math.abs(i[0] - y) + Math.abs(i[1] - x);
					distMin = Math.min(distMin, dist);
				}
			}
			total += distMin;
		}
		return total;
	}

}