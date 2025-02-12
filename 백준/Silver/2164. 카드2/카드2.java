import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            que.addLast(i);
        }
        int idx = 1;
        while(que.size() != 1){
            if(idx % 2 == 0){
                int tmp = que.pollFirst();
                que.addLast(tmp);
            }else{
                que.pollFirst();
            }
            idx++;
        }
        System.out.println(que.poll());

    }
}