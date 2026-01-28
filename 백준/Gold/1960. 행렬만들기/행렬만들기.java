import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> rowPq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.count, o1.count));
        PriorityQueue<Node> culPq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.count, o1.count));
        
        int rowSum = 0;
        int culSum = 0;

        int[][] matrix = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int row = Integer.parseInt(st.nextToken());
            rowPq.add(new Node(i, row));
            rowSum += row;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cul = Integer.parseInt(st.nextToken());
            culPq.add(new Node(i, cul));
            culSum += cul;
        }

        if (rowSum != culSum) {
            System.out.println(-1);
            return;
        }

        //행의 필요한 1만큼 우선순위 큐를 돌면서 1을 뺴준다.

        while (!rowPq.isEmpty()) {
            Node currRow = rowPq.poll();
            ArrayList<Node> list = new ArrayList<>();

            for (int j = 0; j < currRow.count; j++) {
                if (culPq.isEmpty()) {
                    System.out.println(-1);
                    return;
                }

                Node cul = culPq.poll();

                if (cul.count == 0) {
                    System.out.println(-1);
                    return;
                }

                cul.count--;
                matrix[currRow.index][cul.index]++;
                list.add(cul);
            }

            for (Node node : list) {
                culPq.add(node);
            }
        }

        System.out.println(1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }


    }
}
