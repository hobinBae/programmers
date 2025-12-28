import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[][] graph;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            boolean[] visited = new boolean[N];
            dfs(visited, i);
            for (boolean b : visited) {
                if(b){
                    System.out.print(1 + " ");
                }else{
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    static void dfs(boolean[] visited, int start){

            for(int j = 0; j < graph[start].length; j++){
                if(graph[start][j] == 1){
                    if(visited[j]){
                        continue;
                    }
                    visited[j]= true;
                    dfs(visited, j);
                }
            }
        }
        }
