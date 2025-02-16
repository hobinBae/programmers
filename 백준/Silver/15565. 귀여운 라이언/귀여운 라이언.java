import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        ArrayList<Integer>list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){
                list.add(i);
            }
        }
        int answer = Integer.MAX_VALUE;
        if(list.size() >= K){

            int left = 0;
            int right = K - 1;
            while(right < list.size()){
                int length = list.get(right) - list.get(left) + 1;
                answer = Math.min(length , answer);
                left++;
                right++;
            }
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }

       




    }
}