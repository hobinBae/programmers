import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y));
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.getY() == o2.getY()) {
                return Integer.compare(o1.getX(), o2.getX());
            }else{
                return Integer.compare(o1.getY(), o2.getY());
            }
        });
        for (Node node : list) {
            System.out.println(node.getX() + " " + node.getY());
        }

    }

}