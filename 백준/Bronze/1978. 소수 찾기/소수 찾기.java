import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = 0; i < N; i++){
         int a = Integer.parseInt(st.nextToken());
         ArrayList<Integer> list = new ArrayList<>();

            for (int j = 1; j <= a; j++) {
                if (a % j == 0) {
                    list.add(j);
                }
            }
            if(list.size() == 2){
                sum++;
            }

        }
        System.out.println(sum);




    }
}