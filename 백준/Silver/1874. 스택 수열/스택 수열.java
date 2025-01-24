import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N]; // 수열을 담기 위한 배열
        Stack<Integer>stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int index = 0;
        for (int i = 1; i <= N; i++) { // 1부터 N까지 반복하면서 스택에 넣음

            stack.push(i);
            sb.append("+").append("\n");

            if (stack.peek() == arr[index]) {
                stack.pop();
                sb.append("-").append("\n");
                index++;
                while(!stack.isEmpty()){
                    if(stack.peek() != arr[index]){
                        break;
                    }else{
                        stack.pop();
                        sb.append("-").append("\n");
                        index++;
                    }
                }
            }

        }
        if(stack.isEmpty()){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }


    }
}