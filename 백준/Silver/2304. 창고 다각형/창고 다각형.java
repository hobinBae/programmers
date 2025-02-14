import java.util.*;
import java.io.*;
public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxHeight = Integer.MIN_VALUE;
        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            list.add(new int[] {idx, height});
            maxHeight = Math.max(maxHeight, height);
        }
        Collections.sort(list, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        Stack<int[]>stack = new Stack<>();
        ArrayList<Integer> maxIdx = new ArrayList<>();
        int answer = 0;
        for(int i = 0; i < list.size(); i++) {

            if(stack.isEmpty()) {
                stack.push(list.get(i));
            }else {
                if(stack.peek()[1] <= list.get(i)[1]) {

                    int[] arr = stack.pop();
                    answer += (list.get(i)[0] - arr[0]) * arr[1];
                    stack.push(list.get(i));
                }
            }
            if(list.get(i)[1] == maxHeight) {
                maxIdx.add(list.get(i)[0]);
                break;
            }

        }

        stack = new Stack<>();
        for(int i = list.size() - 1; i >= 0; i--){

            if(stack.isEmpty()) {
                stack.push(list.get(i));
            }else{
                if(stack.peek()[1] <= list.get(i)[1]){
                    int[] arr = stack.pop();
                    answer += (arr[0] - list.get(i)[0]) * arr[1];
                    stack.push(list.get(i));
                }
            }
            if(list.get(i)[1] == maxHeight){
                maxIdx.add(list.get(i)[0]);
                break;
            }

        }
        if(maxIdx.get(0) == maxIdx.get(1)){
            System.out.println(answer + maxHeight);
        }else{
            answer += (maxIdx.get(1) - maxIdx.get(0) + 1) * maxHeight;

            System.out.println(answer);
        }



    }
}