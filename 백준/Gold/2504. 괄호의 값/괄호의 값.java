import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();
        map.put("]", "[");
        map.put(")", "(");

        String[] arr = br.readLine().split("");

        Stack<String> stack = new Stack<>();

        for (String s : arr) {
            if(s.isEmpty()){
                continue;
            }
            int sum = 0;
            if (stack.isEmpty()) {
                stack.push(s);
                continue;
            }
            if (!map.containsKey(s)) {
                stack.push(s);
            } else {
                if(map.containsKey(stack.peek())){
                    System.out.println(0);
                    return;
                }
                //만약 앞에 껄 확인했는데 숫자일 때
                if (!stack.peek().equals("(") && !stack.peek().equals("[")) {
                    while (true) {
                        if(stack.isEmpty() || map.containsKey(stack.peek()) ){
                            System.out.println(0);
                            return;
                        }
                        if (stack.peek().equals("(") || stack.peek().equals("[")) {
                            break;
                        } else {

                            sum += Integer.parseInt(stack.pop());
                        }
                    }
                    if (stack.peek().equals(map.get(s))) {
                        stack.push(sum * check(stack.pop()) + "");
                    } else {
                        //다르면 더이상 진행을 할 수 없다.
                        System.out.println(0);
                        return;
                    }
                }else if(stack.peek().equals(map.get(s))){
                    stack.push(check(stack.pop()) + "");
                }else{
                    System.out.println(0);
                    return;
                }

            }
        }
        int answer = 0;
        if(stack.isEmpty()){
            System.out.println(0);
        }else{
            for (String s : stack) {
                if(map.containsKey(s) || s.equals("(") || s.equals("[")){
                    answer = 0;
                    break;
                }
                answer += Integer.parseInt(s);
            }
            System.out.println(answer);
        }




    }

    static int check(String s) {
        if (s.equals("(")) {
            return 2;
        } else {
            return 3;
        }
    }
}
