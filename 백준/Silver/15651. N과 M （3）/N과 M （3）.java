import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static boolean[] used;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        used = new boolean[N + 1];
        sb = new StringBuilder();
        backtrack( 0, "");
        System.out.println(sb);
    }

    private static void backtrack(  int cnt, String s){
        if (cnt == M) {
            sb.append(s.trim() + "\n");
            return;
        }
        for(int i = 1; i <= N; i++){
                backtrack( cnt + 1,  s + " " + i );

        }
    }
}