import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       //최대 좌표
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        //현재 좌표
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());
        //현재위치 p, q에 시간(t)를 더해준다.
        int a = (p + t) / w;
        int b = (q + t) / h;
        if(a % 2 == 0){
            a = (p + t) % w;
        }else{
            a = w - (p + t) % w;
        }

        if(b % 2 == 0){
            b = (q + t) % h;
        }else{
            b = h - (q + t) % h;
        }
        System.out.println(a + " " + b);
    }
}