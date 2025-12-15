import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        if(G == S){
            System.out.println(0);
            return;
        }

        ArrayDeque<Integer> move = new ArrayDeque<>();
        boolean[] visited = new boolean[F + 1];
        int[] building = new int[F + 1];
        building[S] = 0;
        move.add(S);
        visited[S] = true;
        int[] next = {U, -D};

        while (!move.isEmpty()) {
            int now = move.poll();

            for (int i : next) {
                int nextFloor = now + i;
                if (nextFloor <= 0 || nextFloor > F) {
                    continue;
                }

                if(visited[nextFloor]){
                    continue;
                }
                visited[nextFloor] = true;
                building[nextFloor] = building[now] + 1;
                move.add(nextFloor);
            }
        }
        if(building[G] == 0){
            System.out.println("use the stairs");
        }else{
            System.out.println(building[G]);
        }
    }
}
