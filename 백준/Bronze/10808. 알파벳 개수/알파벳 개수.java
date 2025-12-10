import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static BufferedReader br;
    static String s;

    static void input() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
    }

    public static void main(String[] args) throws IOException{
        input();
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
