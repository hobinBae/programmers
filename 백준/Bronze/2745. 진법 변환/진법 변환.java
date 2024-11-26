import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String value = st.nextToken();
        int num = Integer.parseInt(st.nextToken());

        int answer = 0;
        int index = 0;


        for(int i = value.length() -1 ; i >= 0; i--){
            char c = value.charAt(i);
            int a = 0;
            if('0' <= c && c <= '9'){
                a = c - '0';
            }else{
                a = c - 55;
            }
            answer += a * (int)Math.pow(num, index++);
        }
        System.out.println(answer);






    }
    }