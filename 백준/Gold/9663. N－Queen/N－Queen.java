import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int answer;
    static boolean[] col, slash, bslash;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new boolean[N + 1];
        slash = new boolean[2 * N + 1];
        bslash = new boolean[2 * N + 1];
        backtrack(1);
        System.out.println(answer);

    }
    static void backtrack(int row){
    if(row > N){
        answer++;
        return;
    }
        for(int c = 1; c <= N; c++){

            if(!check(row, c)) continue;
            col[c] = slash[row + c] = bslash[(row - c) + N] = true;
            backtrack(row + 1);
            col[c] = slash[row + c] = bslash[(row - c) + N] = false;
        }
    }
    static boolean check(int row, int c){
        return !col[c] && !slash[row + c] && !bslash[(row - c) + N];
    }
}