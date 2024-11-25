import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 1; i <= T; i++){
            String input = br.readLine();
            if(isGroupWord(input)){
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isGroupWord(String word){
        HashSet<Character> set = new HashSet<>();
        char prev = '\0';
        for(char c : word.toCharArray()){
            if(c != prev){
                if(set.contains(c)){
                    return false;
                }
                set.add(c);
            }
            prev = c;
        }
        return true;
    }
}