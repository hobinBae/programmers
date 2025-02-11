import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		x.add(0);
		x.add(M);
		y.add(0);
		y.add(N);
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == 0) {
				//M
				x.add(b);
			}else {
				//N
				y.add(b);
			}
		}
		Collections.sort(x);
		Collections.sort(y);
		
		int maxX = 0;
		int maxY = 0;
		
		for(int i = 1; i < x.size(); i++) {
			int value = x.get(i) - x.get(i - 1);
			maxX = Math.max(maxX, value);
		}
		for(int i = 1; i < y.size(); i++) {
			int value = y.get(i) - y.get(i - 1);
			maxY = Math.max(maxY, value);
		}
		
		System.out.println(maxX * maxY);

	
		
	}


}