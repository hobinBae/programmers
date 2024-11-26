import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Character> stack = new Stack<>();
        int value = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        while(value > 0){
            int b = value % num;
            char c = 0;
            if(b >= 0 && b <= 9){
                c = (char)(b + '0');
                stack.push(c);
            }else{
                c = (char)(b + 55);
                stack.push(c);
            }
            value /= num;
        }

        char[] answer = new char[stack.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.pop();
        }
        for (char c : answer) {
            System.out.print(c);
        }
    }
    }