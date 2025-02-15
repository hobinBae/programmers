import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        arr[0] = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int button = Integer.parseInt(st.nextToken());
            arr[i] = button;
        }

        int student = Integer.parseInt(br.readLine());
        for(int i = 0; i < student; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(s == 1){
                for(int j = num; j < arr.length; j += num){
                    arr[j] = arr[j] == 0 ? 1 : 0;
                }
            }else if(s == 2){
                int j = 1;
                while(true){
                    if(num + j > N || num -j < 1){
                        break;
                    }
                    if(arr[num + j] == arr[num - j]) {
                        j++;
                    }else{
                        break;
                    }
                }
                j--;
                for(int k = num - j; k <= num + j; k++){
                    arr[k] = arr[k] == 0 ? 1 : 0;
                }
            }
        }
        for(int i = 1; i <= N; i++){
            System.out.print(arr[i] + " ");
            if(i % 20 == 0){
                System.out.println();
            }
        }
    }
}