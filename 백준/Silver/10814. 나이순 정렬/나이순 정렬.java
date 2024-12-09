import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        private int age;
        private String name;
        private int index;

        public Node(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        public int getAge(){
            return age;
        }
        public String getName(){
            return name;
        }
        public int getIndex(){
            return index;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Node(age, name, idx++));
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.getAge() == o2.getAge()){
                return Integer.compare(o1.getIndex(), o2.getIndex());
            }else{
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        for (Node node : list) {
            System.out.println(node.getAge() + " " + node.getName());
        }
    }

}