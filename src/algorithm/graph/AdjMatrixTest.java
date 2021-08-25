package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjMatrixTest {

    static int N; // 정점 개수
    static boolean[][] adjMatrix; // 가중치 없는 인접 행렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjMatrix = new boolean[N][N];
        int C = Integer.parseInt(br.readLine()); // 간선 개수
        for(int i = 0; i <C; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = adjMatrix[to][from] = true; // 인접한 정점임을 표시
        }
        System.out.println("============================bfs==========================");
        bfs();

        System.out.println("============================dfs==========================");
        boolean[] visited = new boolean[N];
        dfs(0, visited);

    }

    /**
     * 같은 레벨을 같이 출력함.
     */
    private static void bfs(){

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.offer(0); // 시작 정점
        visited[0] = true; // 방문한 정점 표시

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.println((char)(current + 65));

            for(int i = 0; i < visited.length; i++){
                if(!visited[i] && adjMatrix[current][i]){ // 방문한 상태가 아니고, 현재 상태에서 다른 정점으로 갈 수 있는 경우
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(int current, boolean[] visited){
        visited[current] = true;
        System.out.println((char)(current + 65));
        for(int i = 0; i < N; i++){
            if(!visited[i] && adjMatrix[current][i]){
                dfs(i, visited);
            }
        }
    }
}
