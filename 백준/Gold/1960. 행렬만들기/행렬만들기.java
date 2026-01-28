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

//        PriorityQueue<Node> rowPq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.count, o1.count));
        int[] row = new int[N];
        Integer[] order = new Integer[N];
        PriorityQueue<Node> culPq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.count, o1.count));

        int rowSum = 0;
        int culSum = 0;

        int[][] matrix = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int rowValue = Integer.parseInt(st.nextToken());
//            rowPq.add(new Node(i, row));
            row[i] = rowValue;
            rowSum += rowValue;
            order[i] = i;
        }

        Arrays.sort(order, (o1, o2) -> Integer.compare(row[o2], row[o1]));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int culValue = Integer.parseInt(st.nextToken());
            culPq.add(new Node(i, culValue));
            culSum += culValue;
        }

        if (rowSum != culSum) {
            System.out.println(-1);
            return;
        }

        //행의 필요한 1만큼 우선순위 큐를 돌면서 1을 뺴준다.

        for(int i = 0; i < N; i++){
            int currRow = row[order[i]];
            ArrayList<Node> list = new ArrayList<>();

            for (int j = 0; j < currRow; j++) {
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
                matrix[order[i]][cul.index]++;
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
