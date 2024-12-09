import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        String[] str = new String[set.size()];
        int index = 0;
        for (String s : set) {
            str[index++] = s;
        }
        Arrays.sort(str, (o1, o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }else{
                return Integer.compare(o1.length(), o2.length());
            }
        });
        for (String s : str) {
            System.out.println(s);
        }
    }

}