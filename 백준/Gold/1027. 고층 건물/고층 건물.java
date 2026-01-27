import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] buildings = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = 0; i < N; i ++){
            double slope = Integer.MIN_VALUE;
            int count = 0;
            for(int j = i + 1; j < N; j++){
                double currSlope = calculateSlope(buildings[j] - buildings[i], j - i);
                if(currSlope > slope){

                    count++;
                    slope = currSlope;
                }
            }
            slope = Integer.MIN_VALUE;
            for(int j = i - 1; j >= 0; j--){
                double currSlope = calculateSlope(buildings[j] - buildings[i], i - j);
                if(currSlope > slope){

                    count++;
                    slope = currSlope;
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);

    }

    // 기울기는 y의 증가량 / x의 증가량
    static double calculateSlope(int y, int x){
        return (double) y / x;
    }
}
