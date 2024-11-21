import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] alpha = new String[26];
        int[] answer = new int[26];
        for (int i = 0; i < 26; i++) {
            alpha[i] = String.valueOf((char) ('a' + i));
        }
        String a = br.readLine();
        for (int i = 0; i < alpha.length; i++) {
            answer[i] = a.indexOf(alpha[i]);

        }
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}