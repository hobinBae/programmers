import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		int stick = 1;
		int answer = 1;
		for(int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == ')') {
				if(stack.peek() == '(') {
					stick--;
					answer--;
					answer += stick;
					stack.push(c);
				}else {
					stick--;
				}
			}else {
				stick++;
				answer++;
			}
			stack.push(c);
			
		}
		
		System.out.println(answer);
	}

}