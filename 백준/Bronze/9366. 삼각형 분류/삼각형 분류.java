import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


            if(a == b && b == c){
                System.out.println("Case #" + i + ": equilateral");
                continue;
            }

            int[] arr = {a, b, c};
            Arrays.sort(arr);
            if(arr[2] >= arr[0] + arr[1]){
                System.out.println("Case #" + i + ": invalid!");
                continue;
            }

            if(arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]){
                System.out.println("Case #" + i + ": isosceles");
                continue;
            }

            System.out.println("Case #" + i + ": scalene");

        }

    }
}