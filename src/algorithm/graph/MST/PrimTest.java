package algorithm.graph.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimTest {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 정점의 크기
        int[][] adjMatrix = new int[N][N]; // 인접행렬

        boolean[] visited = new boolean[N];
        int[] minEdge = new int[N];

        StringTokenizer st = null;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <N; j++){
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE; // 아직 확인되지 않은 정점임을 표시 ( minEdge 초기화 )
        }

        int result = 0; // 최소신장트리 비용
        minEdge[0] = 0; // 임의의 시작점 0의 간선비용을 0으로 세팅

        for (int i = 0; i < N; i++) {
            // 1. 신장트리에 포함되지 않은 정점 중 최소 간선비용의 정점 찾기
            int min = Integer.MAX_VALUE;
            int minVertex = -1;
            for (int j = 0; j < N; j++) {
                if(!visited[j] // 아직 방문하지 않은 정점이고,
                        && min > minEdge[j]){ // 그 중 가장 작은 간선이라면, 
                    min = minEdge[j]; // 최소 비용을 저장하고,
                    minVertex = j; // 해당 간선을 저장
                }
            }

            visited[minVertex] = true; // 신장트리에 포함시킴
            result += min; // 간선비용 누적

            // 2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
            for (int j = 0; j < N; j++) {
                if(!visited[j] // 신장트리에 포함되지 않은 정점이고,
                        && adjMatrix[minVertex][j] != 0 // 현재 정점과 연결하려는 정점을 연결할 수 있고 (간선이 존재하고)
                        && minEdge[j] > adjMatrix[minVertex][j]){ // 그 중 기존에 저장했던 최소 간선의 비용보다 연결할 간선의 비용이 더 작다면,
                    minEdge[j] = adjMatrix[minVertex][j]; // 새로 들어온 정점에서 업데이트되는 minEdge
                }
            }
        }
        System.out.println(result);
    }
}
