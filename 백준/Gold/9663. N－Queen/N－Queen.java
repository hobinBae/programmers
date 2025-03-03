import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static boolean[] col, slash, bslash;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new boolean[N + 1];
        slash = new boolean[2 * N + 1];
        bslash = new boolean[2 * N + 1];
        answer = 0;
        backtrack(1);
        System.out.println(answer);
    }
    static void backtrack(int row){
        if(row > N){
            answer++;
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!check(row, i))continue;
            col[i] = slash[row + i] = bslash[(row - i) + N] = true;
            backtrack(row + 1);
            col[i] = slash[row + i] = bslash[(row - i) + N] = false;
        }
    }
    static boolean check(int row,int c){
        return !col[c] && !slash[row + c] && !bslash[(row - c) + N];
    }
}