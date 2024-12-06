import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        ArrayList<Integer>list = new ArrayList<>();
        int idx = 0;
        for(int i = 1; i <= a; i++){
            if(a % i == 0){
                list.add(i);
            }
        }

        Collections.sort(list);

        if(list.size() < b){
            System.out.println(0);
        }else{
            System.out.println(list.get(b - 1));
        }

    }
}