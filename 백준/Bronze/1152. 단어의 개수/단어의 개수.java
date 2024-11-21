import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split(" ");
        int sum = 0;
        for (String s : arr) {
            if(!s.isEmpty()){
                sum++;
            }
        }
        System.out.println(sum);
    }
}