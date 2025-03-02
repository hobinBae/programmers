import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (np()) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println(-1);
        }

    }

    static boolean np() {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }

        swap(i - 1, j);
        int k = arr.length - 1;
        while (i < k) {
            swap(i++, k--);
        }
        return true;
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}