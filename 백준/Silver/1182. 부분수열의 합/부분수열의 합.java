import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtrack(0,   new ArrayList<>());
        System.out.println(answer);
    }
    static void backtrack(int cnt, ArrayList<Integer>list){

        if(cnt == N){
            int sum = 0;
            if(list.isEmpty()){
                return;
            }
            for (Integer i : list) {
                sum += i;
            }
            if(sum == M)
                answer++;
            return;
        }
            list.add(arr[cnt]);
            backtrack(cnt + 1,  list);
            list.remove(list.size() - 1);
            backtrack(cnt + 1,   list);

    }
}