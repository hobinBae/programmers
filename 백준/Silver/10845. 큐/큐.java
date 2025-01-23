import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer>dq = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    dq.addLast(value);
                    break;
                case "pop":
                    if(!dq.isEmpty()){
                        sb.append(dq.pollFirst()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if(dq.isEmpty()){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(!dq.isEmpty()){
                        sb.append(dq.peekFirst()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if(!dq.isEmpty()){
                        sb.append(dq.peekLast()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);

    }

}