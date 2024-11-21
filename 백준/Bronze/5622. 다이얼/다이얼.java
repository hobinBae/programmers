import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ABC", 2);
        map.put("DEF", 3);
        map.put("GHI", 4);
        map.put("JKL", 5);
        map.put("MNO", 6);
        map.put("PQRS", 7);
        map.put("TUV", 8);
        map.put("WXYZ", 9);

        String[] s = br.readLine().split("");
        int sum = 0;
        for(int i = 0 ; i < s.length; i++){
            for (String string : map.keySet()) {
                if(string.contains(s[i])){
                    sum += map.get(string) + 1;
                }
            }
        }
        System.out.println(sum);



    }
}