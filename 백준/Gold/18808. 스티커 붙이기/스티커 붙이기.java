import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N;
    static int M;
    static int K;

    static int[][] notebook;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        notebook = new int[N][M];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[R][C];
            for(int j = 0; j < R; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < C; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            execute(sticker);
            //여기에서 놓거나 놓을 수 있는지 없는지 판단하면 될 듯
        }
        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(notebook[i][j] == 1){
                    answer++;
                }
            }
        }
        System.out.println(answer);


    }

    static void execute(int[][] sticker){
        for(int rotate = 0; rotate < 4; rotate++){
            for(int i = 0; i <= N - sticker.length; i++){
                for(int j = 0; j <= M - sticker[0].length; j++){
                    if (isAttachable(i, j, sticker)) {
                        //여기에 붙이는 함수 호출
                        attach(i, j, sticker);
                        return;
                    }
                }
            }
            // 돌리는 함수 호출
            sticker = rotate(sticker);
        }
    }
    static int[][] rotate(int[][] sticker){
        int r = sticker.length;
        int c = sticker[0].length;
        int[][] stickerCopy = new int[c][r];

        for(int i = 0; i < c; i++){
            for(int j = 0; j < r; j++){
                stickerCopy[i][j] = sticker[r - 1 - j][i];
            }
        }
        return stickerCopy;
    }

    static void attach(int y, int x, int[][] sticker){
        for(int i = 0; i < sticker.length; i++){
            for(int j = 0; j < sticker[0].length; j++){
                if(sticker[i][j] == 1){
                    notebook[y + i][x + j] = sticker[i][j];
                }

            }
        }

    }
    static boolean isAttachable(int y, int x, int[][] sticker) {
        for(int i = 0; i < sticker.length; i++){
            for(int j = 0; j < sticker[i].length; j++){
                if(check(i , j)){
                    return false;
                }
                if(notebook[y + i][x + j] == 1 && sticker[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean check(int i, int j) {
        return i < 0 || i >= N || j < 0 || j >= M;
    }
}
