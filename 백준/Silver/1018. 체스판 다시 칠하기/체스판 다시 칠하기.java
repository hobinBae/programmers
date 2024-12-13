import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static char[][] arr;
    private final static char[][] patternW = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
    };
    private final static char[][] patternB = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int row = N - 8;
        int col = M - 8;

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                int value = solution(i, j);
                min = Math.min(min, value);
            }
        }
        System.out.println(min);
    }

    private static int solution(int row, int col) {
        char[][] arrClone = new char[8][8];
        int rowIndex = 0;
        int sumW = 0;
        int sumB = 0;
        for (int i = row; i < row + 8; i++) {
            int colIndex = 0;
            for (int j = col; j < col + 8; j++) {
                arrClone[rowIndex][colIndex++] = arr[i][j];
            }
            rowIndex++;
        }

        for (int i = 0; i < arrClone.length; i++) {
            for (int j = 0; j < arrClone.length; j++) {
                if (arrClone[i][j] != patternW[i][j]) {
                    sumW++;
                }

                if (arrClone[i][j] != patternB[i][j]) {
                    sumB++;
                }
            }
        }

        return Math.min(sumW, sumB);
    }

}