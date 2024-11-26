import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 2;
        for(int i = 0; i < N; i++){
            num = (num * 2) - 1;
        }
        System.out.println(num * num);
    }
    }