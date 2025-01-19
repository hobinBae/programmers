import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '<') {
                if (!deque.isEmpty()){
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                    }
                System.out.print(sb);
                sb.setLength(0);
            }
                while(c != '>'){
                    c = S.charAt(i++);
                    deque.addLast(c);
                }
                i--;

                while(!deque.isEmpty()){
                    sb.append(deque.pollFirst());
                }
                System.out.print(sb);
                sb.setLength(0);

            }else if(c == ' '){
                while(!deque.isEmpty()){
                    sb.append(deque.pollLast());
                }
                System.out.print(sb);
                System.out.print(" ");
                sb.setLength(0);
            }else{
                deque.addLast(c);
            }

        }

        if(!deque.isEmpty()) {
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast());
            }
            System.out.print(sb);
        }
    }
}