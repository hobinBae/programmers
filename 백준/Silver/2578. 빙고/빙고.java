import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] check;
	static int[][] arr;
	static int N;
	static int[] dr = {0, 0, 1, -1, -1, 1, 1, -1};
    static int[] dc = {1, -1, 0, 0, 1, 1, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 5;
		arr = new int[N][N];
		check = new boolean[N][N];
		HashMap<Integer, int[]> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				map.put(arr[i][j], new int[] {i,j} );
			}
		}
		int answer = 0;
		for(int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < arr.length; j++) {
				int value = Integer.parseInt(st.nextToken());
				int x = map.get(value)[0];
				int y = map.get(value)[1];
				answer++;
				check[x][y] = true;
				
				if(bingo()) {
					System.out.println(answer);
					return;
				}
				
			}
		}
	}
	
	private static boolean bingo() {
		int sum = 0;
		for(int i = 0; i < N ;i++) {
			//상하 죄우는 상은 col이 바뀌게끔
			//좌는 row가 바뀌겠끔 
			//상하
			sum += bingoCheck(0, i, 2);
			//좌우
			sum += bingoCheck(i, 0, 0);
		}
		sum += bingoCheck(0, 4, 6);
		//대각선2
		sum += bingoCheck(0, 0, 5);
		// sum이 3이상이면 true 리턴 이하면 false리턴
		if(sum >= 3) {
			return true;
		}
		return false;
	}
	
	private static int bingoCheck(int i, int j, int d) {
		int sum = 0;
		int row = i;
		int col = j;
		
		if(!check[row][col]) {
			return 0;
		}
		sum++;
		for(int k = 0; k < 5; k++) {
			int nextRow = row + dr[d];
			int nextCol = col + dc[d];
			if(nextRow >= N || nextCol >= N || nextRow < 0 || nextCol < 0 || !check[nextRow][nextCol]) {
				break;
			}
			sum++;
			row = nextRow;
			col = nextCol;
			
		}
	
		
		if(sum == 5) {
			return 1;
		}
		return 0;
	}
}