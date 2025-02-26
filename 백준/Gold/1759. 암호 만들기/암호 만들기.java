import java.util.*;
import java.io.*;
public class Main {
    static int L;
    static int C;
    static String[] arr;
    static ArrayList<String> list;
    static Set<String>set;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        set = new HashSet<>();
        set.add("a");
        set.add("e");
        set.add("i");
        set.add("o");
        set.add("u");

         L = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
         st = new StringTokenizer(br.readLine());
         arr = new String[C];
         list = new ArrayList<>();
         for(int i = 0 ; i < C; i++){
             arr[i] = st.nextToken();
         }
         Arrays.sort(arr);
         backtrack(0, 0);
        System.out.println(sb);

    }

    static void backtrack(int cnt, int start){
        if(cnt == L){
            int a = 0;
            int b = 0;
            for (String s : list) {
                if(set.contains(s)){
                    a++;
                }else
                    b++;
            }
            if(a > 0 && b > 1){
                for (String s : list) {
                    sb.append(s);
                }
                sb.append("\n");

            }else{
                return;
            }

        }

        for(int i = start; i < C; i++){
                list.add(arr[i]);
                backtrack(cnt + 1, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }