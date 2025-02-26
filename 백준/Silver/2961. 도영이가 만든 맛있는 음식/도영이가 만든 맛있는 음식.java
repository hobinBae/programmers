import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[] so;
	static int[] sa;
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		so = new int[N];
		sa = new int[N];
		min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			so[i] = Integer.parseInt(st.nextToken());
			sa[i] = Integer.parseInt(st.nextToken());
		}
		backtrack(0, 0, 1, 0);
		System.out.println(min);
		
	}
	
	static void backtrack(int cnt, int start, int sumSo, int sumSa) {
		if(cnt == N) {
			if(sumSo == 0 || sumSa == 0) {
				return;
			}
		
			int value = Math.abs(sumSo - sumSa);
			min = Math.min(min, value);
			return;
		}
		
		for(int i = start; i < N; i++) {			
			backtrack(cnt + 1, i + 1, sumSo * so[i], sumSa + sa[i]);
			backtrack(cnt + 1, i + 1, sumSo, sumSa);
		}
	}
}