import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        int[] answer = new int[2];
        for(int i = 0; i < 28; i++){
            int student = Integer.parseInt(br.readLine());
            set.add(student);
        }
        int index = 0;
        for(int i = 1; i <= 30; i++){
            if(!set.contains(i)){
                answer[index++] = i;
            }

        }
        Arrays.sort(answer);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}