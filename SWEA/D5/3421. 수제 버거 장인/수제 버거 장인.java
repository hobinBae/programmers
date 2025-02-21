import java.util.*;
import java.io.*;
public class Solution {
    static int N;
    static int M;
    static ArrayList<HashSet<Integer>>worst;
    //	static Set<Integer> answer;
    static int answer;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
//			 answer = new HashSet<>();
            answer = 0;
            arr = new int[N];
            worst = new ArrayList<>(N + 1);
            for(int i = 0; i <= N; i++) {
                worst.add(new HashSet<>());
            }
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                worst.get(a).add(b);
                worst.get(b).add(a);
            }
            int idx = 0;
            for(int i = 1; i <= N; i++) {
                arr[idx++] = i;
            }
            backtrack(0, new ArrayList<>());

            System.out.println("#" + t + " " + answer);

        }
    }

    static void backtrack(int cnt, ArrayList<Integer> list ) {
        if(cnt == arr.length) {

            if(list.isEmpty()) {
                answer++;
                return;
            }
            if(M == 0) {
                answer++;
                return;
            }
            for(int i = 0; i < list.size(); i++){
                for(int j = i + 1; j < list.size(); j++){
                    if(worst.get(list.get(i)).contains(list.get(j))){
                        return;
                    }
                }
            }

            answer++;
            return;
        }

        list.add(arr[cnt]);
        backtrack(cnt + 1, list);
        list.remove(list.size() - 1);
        backtrack(cnt + 1, list);



    }
}