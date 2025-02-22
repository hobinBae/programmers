import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
//        Set<Integer> set = new HashSet<>();
        arr = new int[N];
        used = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
//            set.add(Integer.parseInt(st.nextToken()));
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);
        backtrack(0, new ArrayList<>());
        System.out.println(sb);
    }

    static void backtrack(int cnt, ArrayList<Integer> list){
        if(cnt == M){
            StringBuilder sb1 = new StringBuilder();
            for (Integer i : list) {
                sb1.append(i).append(" ");

            }
            if(sb.toString().contains(sb1.toString())){
                return;
            }
            sb.append(sb1);
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++){
            if(!used[i]){
                used[i] = true;
                list.add(arr[i]);
                backtrack(cnt + 1, list);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}