import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 N 명
        int K = Integer.parseInt(st.nextToken()); // K 번째 제거
        ArrayDeque<Integer>dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 1; i <= N; i++){ // N명 만큼 deque에 사람을 넣어준다.
            dq.addLast(i);
        }

        int index = 1;
        while(!dq.isEmpty()){
            if(index % K == 0){
                sb.append(dq.pollFirst()).append(", ");
            }else{
                dq.addLast(dq.pollFirst());
            }
            index++;
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb);

    }
}