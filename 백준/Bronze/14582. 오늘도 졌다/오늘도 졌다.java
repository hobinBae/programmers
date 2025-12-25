import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] j = new int[9];
        int[] s = new int[9];

        for(int i = 0; i < 9; i++){
            j[i]= Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        boolean win = false;
        int jScore = 0;
        int sScore = 0;
        for(int i = 0; i < 9; i++){
            jScore += j[i];
            if (jScore > sScore) {
                win = true;
            }
            sScore += s[i];

        }

        if (win && sScore > jScore) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }
}
