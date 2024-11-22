import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = {"c=","c-","dz=", "d-", "lj", "nj", "s=", "z="};
        String input = br.readLine();
        int sum = 0;
        for (String s : arr) {
            if(input.contains(s)){
                 input = input.replace(s, " ");
                 sum++;
            }
        }



        if(input.trim().isEmpty()){
            System.out.println(input.length());
        }else{
            System.out.println(input.replaceAll(" ", "a").length());
        }
    }
}