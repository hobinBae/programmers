import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> map = new HashMap<>();
        String a = br.readLine().toUpperCase();
        for(int i = 0; i < a.length(); i++){
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        char maxC = ' ';
        for (Character c : map.keySet()) {
            int value = map.get(c);
            if(value > max){
                max = value;
                maxC = c;
            }
        }

        int sum = 0;
        for (Integer value : map.values()) {
  
            if(max == value){
                sum++;
            }
        }
        if(sum > 1){
            System.out.println("?");
        }else{
            System.out.println(maxC);
        }

    }
}