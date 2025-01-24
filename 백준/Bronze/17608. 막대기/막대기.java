import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 막대기의 개수
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			int h = Integer.parseInt(br.readLine());
			deque.addLast(h);
		}
		int sum = 1;
		int value = deque.pollLast();
		
		while(!deque.isEmpty()) {
			if(deque.peekLast() > value) {
				value = deque.pollLast();
				sum++;
			}else {
				deque.pollLast();
			}
		}

		System.out.println(sum);
		

	}

}
