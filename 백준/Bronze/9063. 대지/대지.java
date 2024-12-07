import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        if(N < 2){
            System.out.println(0);
        }else{
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                maxX = Math.max(maxX, X);
                minX = Math.min(minX, X);

                maxY = Math.max(maxY, Y);
                minY = Math.min(minY, Y);
            }
            System.out.println((maxX - minX) * (maxY - minY));
        }
    }
}