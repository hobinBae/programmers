import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[][] colorPaper;
    static int N;
    static int minusCount;
    static int zeroCount;
    static int oneCount;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colorPaper = new int[N][N];

        answer = new int[]{0, 0, 0};

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                colorPaper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        re(0, 0, N);
        for (int i : answer) {
            System.out.println(i);
        }


    }
    static void re(int x, int y, int n){
        if (check(x, y, n)) {
            answer[colorPaper[x][y] + 1]++;
            return;
        }
        n /= 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                re(x + i * n, y + j * n, n);

            }
        }

    }

    static boolean check(int x, int y, int n){
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                if (colorPaper[x][y] != colorPaper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
