import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        used = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtrack(0, 0, new ArrayList<>());
        System.out.println(sb);

    }
    static void backtrack(int start, int cnt,  ArrayList<Integer> list){
        if(cnt == M){
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        int pre = 0;
        for(int i = start; i < N; i++){
            if(pre == arr[i]) continue;
            if (!used[i]) {
                used[i] = true;
                pre = arr[i];
                list.add(arr[i]);
                backtrack(i + 1, cnt + 1, list);
                list.remove(list.size() - 1);
                used[i] = false;
            }

        }
    }
}