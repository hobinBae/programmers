import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        StringBuilder sb = new StringBuilder(a);
        if(a.equals(sb.reverse().toString())){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }
}