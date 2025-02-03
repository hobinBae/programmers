import java.util.*;
import java.io.*;
public class Main {
    private static String[] arr;
    private static boolean[] visited;
    private static int N;
    private static int K;
    private static Set<String>set = new HashSet<>();
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
         arr = new String[N];
         visited = new boolean[N];
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }
        back(0);
        System.out.println(set.size());
    }
    private static void back( int depth){
        if(depth == K){
            set.add(sb.toString());
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if (!visited[i]) {
                visited[i] = true;
                sb.append(arr[i]);
                back(depth + 1);
                sb.setLength(sb.length() - arr[i].length());
                visited[i] = false;
            }
        }
    }
}