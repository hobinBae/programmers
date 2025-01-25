import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static class Node {
        private int value;
        private int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;

        }

        public int getValue(){
            return value;
        }
        public int getIndex(){
            return index;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Node> que = new ArrayDeque<>();
        ArrayList<Node> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            que.addLast(new Node(a, i));
        }
        list.add(que.pollFirst());
        sb.append(list.get(0).getIndex() + 1).append(" ");
        int i = 0;
        while(!que.isEmpty()){
            int idx = list.get(i).getValue();
            if(idx > 0) {
                for (int j = 0; j < idx; j++) {
                    que.addLast(que.pollFirst());
                }
                i++;
                list.add(que.pollLast());
                sb.append(list.get(i).getIndex() + 1).append(" ");

            }else if(idx < 0){
                idx = Math.abs(idx);
                for (int j = 0; j < idx; j++) {
                    que.addFirst(que.pollLast());
                }
                i++;
                list.add(que.pollFirst());
                sb.append(list.get(i).getIndex() + 1).append(" ");
            }

        }

        System.out.println(sb);




        }
}