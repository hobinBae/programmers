import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> mapX = new HashMap<>();
        HashMap<Integer, Integer> mapY = new HashMap<>();


        for (int i = 1; i <= 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            mapX.put(X, mapX.getOrDefault(X, 0) + 1);
            mapY.put(Y, mapY.getOrDefault(Y, 0) + 1);

        }
  
        for (Integer i : mapX.keySet()) {
            if(mapX.get(i) == 1){
                System.out.print(i + " ");
            }
        }
        for (Integer i : mapY.keySet()) {
            if (mapY.get(i) == 1) {
                System.out.print(i);
            }
        }



    }
}