import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 10; i++){
            int a = Integer.parseInt(br.readLine()) % 42;
           set.add(a);
       }
        System.out.print(set.size());
    }
}