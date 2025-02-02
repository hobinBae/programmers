import java.util.*;
import java.io.*;
public class Main {
    private static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dice = new int[N][6];
        map.put(0, 5);
        map.put(1, 3);
        map.put(2, 4);
        map.put(5, 0);
        map.put(3, 1);
        map.put(4, 2);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int i = 0; i < 6; i++) {
            int bottom = dice[0][i];
            int top = dice[0][map.get(i)];
            int sum = getMax(dice[0], bottom, top);

            for(int j = 1; j < N; j++){
                for(int k = 0; k < 6; k++){
                    if(dice[j][k] == top){
                        bottom = dice[j][k];
                        top = dice[j][map.get(k)];
                        sum += getMax(dice[j], bottom, top);
                        break;
                    }
                }
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    private static int getMax(int[] dice, int bottom, int top){
        int max = 0;
        for(int i = 0; i < dice.length; i++){
            if(dice[i] != bottom && dice[i] != top){
                max = Math.max(max, dice[i]);
            }
        }
        return max;
    }
}