import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        used = new boolean[N];
        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        arr = new int[set.size()];
        int idx = 0;
        for (Integer i : set) {
            arr[idx++] = i;
        }
        Arrays.sort(arr);
        backtrack(0, 0, new ArrayList<>());
        System.out.println(sb);

    }

    static void backtrack( int start, int cnt, ArrayList<Integer> list) {
        if (cnt == M) {
            ArrayList<Integer> list1 = new ArrayList<>(list);
            Collections.sort(list1);
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        int pre = -1;
        for (int i = start; i < arr.length; i++) {
            if (pre == arr[i]) {
                continue;
            }
                pre = arr[i];
                list.add(arr[i]);
                backtrack(i, cnt + 1, list);
                list.remove(list.size() - 1);

        }
    }
}