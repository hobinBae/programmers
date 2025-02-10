import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<Integer, Integer> mapA = new HashMap<>();
            HashMap<Integer, Integer> mapB = new HashMap<>();
            for(int j = 1; j <=4; j++){
                mapA.put(j, 0);
                mapB.put(j, 0);
            }
            int a = Integer.parseInt(st.nextToken());
            for(int j = 0; j < a; j++){
                int value = Integer.parseInt(st.nextToken());
               mapA.put(value, mapA.getOrDefault(value, 0) + 1);
            }
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for(int j = 0; j < b; j++){
                int value = Integer.parseInt(st.nextToken());
                mapB.put(value, mapB.getOrDefault(value, 0) + 1);
            }

            boolean d = false;
            for(int j = 4; j >=1; j--){
                if(mapA.get(j) > mapB.get(j)){
                    System.out.println("A");
                    break;
                } else if (mapA.get(j) < mapB.get(j)) {
                    System.out.println("B");
                    break;
                }
                if(j == 1){
                    d = true;
                }
            }
            if(d){
                System.out.println("D");
            }


        }
    }
}