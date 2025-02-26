import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());
		 int[][] arr = new int[N][2];
		 for(int i = 0; i < N; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 int start = Integer.parseInt(st.nextToken());
			 int end = Integer.parseInt(st.nextToken());
			 arr[i][0] = start;
			 arr[i][1] = end;
		 }
		 
		 Arrays.sort(arr, (o1, o2) -> {
			 if(o1[1] == o2[1]) {
				 return Integer.compare(o1[0], o2[0]);
			 }else {
				 return Integer.compare(o1[1],o2[1]);
			 }
		 });
		int answer = 1;
		int end = arr[0][1];
		
		for(int i = 1; i < N; i++) {
			if(end <= arr[i][0]) {
				answer++;
				end = arr[i][1];
			}
		}
		System.out.println(answer);
		
	}

}