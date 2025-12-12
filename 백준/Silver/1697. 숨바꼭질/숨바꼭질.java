import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //수빈 위치
        int su = Integer.parseInt(st.nextToken());
        //동생 위치
        int bro = Integer.parseInt(st.nextToken());

        if(su == bro){
            System.out.println(0);
            return;
        }
        int[] dist = new int[100001];

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        //방문 처리를 위해 3차원 배열
        //앞으로 1, 뒤로 1, 순간이동
        boolean[] visited = new boolean[100001];
        visited[su] = true;
        dq.add(su);
        while(!dq.isEmpty()){
            int now = dq.poll();

            if(valid(now - 1) && !visited[now - 1]){

                visited[now - 1]= true;
                dist[now - 1] = dist[now] + 1;
                dq.add(now - 1);
            }

            if(valid(now + 1) && !visited[now + 1]){

                visited[now + 1] = true;
                dist[now + 1] = dist[now] + 1;
                dq.add(now + 1);
            }

            if(valid(now * 2) && !visited[now * 2]){

                visited[now * 2] = true;
                dist[now * 2] = dist[now] + 1;
                dq.add(now * 2);
            }

            if(dist[bro] > 0){
                System.out.println(dist[bro]);
                break;
            }
        }

    }

    static boolean valid(int x){
        return x >= 0 && x <= 100000;
    }

}
