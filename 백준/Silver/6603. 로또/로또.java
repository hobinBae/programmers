import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static boolean[] used;
    static int[] arr;
    static int size;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while(true){
            String now = br.readLine();

            if (now.equals("0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(now);

            size = Integer.parseInt(st.nextToken());
            arr = new int[size];
            used = new boolean[size];

            for(int i = 0; i < size; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] lotto = new int[6];

            back(lotto, 0, 0);
            sb.append("\n");

        }
        System.out.println(sb);


    }
    static void back(int[] lotto, int cnt, int start){
        if(cnt >= 6){
            for (int i : lotto) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < size; i++){
                lotto[cnt] = arr[i];
                back(lotto, cnt + 1, i + 1);
            }
        }
//        if(!used[cnt]){
//            used[cnt] = true;
//            lotto[cnt] = arr[cnt];
//            back(lotto, cnt + 1);
//            used[cnt] = false;
//
//        }

}
