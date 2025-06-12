import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static boolean[] used;
    static ArrayList<Integer> list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         used = new boolean[N + 1];
         list = new ArrayList<>();
         back(0);
        System.out.println(sb);
    }

    static void back(int cnt){
        if(cnt == M){
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!used[i]){
                used[i] = true;
                list.add(i);
                back(cnt + 1);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
