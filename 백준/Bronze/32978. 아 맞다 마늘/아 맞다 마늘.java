import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            String food = st.nextToken();
            map.put(food, map.getOrDefault(food, 0) + 1);
        }

        String[] str = br.readLine().split(" ");

        for (String s : str) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : map.keySet()) {
            if(map.get(s) == 1){
                System.out.println(s);
                return;
            }
        }

    }
}
