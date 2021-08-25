package algorithm.graph.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KruskalTest {

    static class Edge implements Comparable<Edge>{
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
//            return this.weight - o.weight; // 간선의 부호가 모두 같을 때
            return Integer.compare(this.weight, o.weight);
        }
    }

    
    static int V, E;
    static Edge[] edgeList;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken()); // 정점의 수
        int E = Integer.parseInt(st.nextToken()); // 간선의 수
        
        // 간선 리스트 작성
        edgeList = new Edge[E]; // 간선 개수만큼 생성

        for(int i  = 0; i < E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(start, end, weight);
        }

        Arrays.sort(edgeList); // 오름차순으로 정렬
        
        make(); // 모든 정점을 각각 집합으로 만들고 시작함.

        int count = 0, result = 0;
        for (Edge edge : edgeList) {
            if(union(edge.start, edge.end)){ // union 했을 때 합쳐진다면 == 사이클이 생기지 않은 경우에
                result += edge.weight;
                if(++count == V-1) break; // 간선의 수가 v-1개가 되는 경우에 멈춤.
            }
        }

    }

    // 최초에 모든 집합을 단위집합으로 생성
    private static void make(){
        parents = new int[V];
        // 모든 원소를 자신을 대표자로 만듦
        for(int i = 0; i < V; i++){
            parents[i] = i;
        }
    }

    // a가 속한 집합의 대표자 찾기
    private static int find(int a){
        if(a==parents[a]) return a; // 자신이 대표자인 경우
        return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의 부모로 : Path Compression
    }

    // 앞의 집합에 합침
    private static boolean union(int a, int b){
        int aRoot = find(a); // a의 대표자
        int bRoot = find(b); // b의 대표자
        if(aRoot == bRoot) return false; // 두 대표자가 같은 경우 == 같은 집합인 경우 >> 합치지 않음

        // 합치는 경우 대표자끼리 합치는 것에 유의
        parents[bRoot] = aRoot; // b 대표자를 a대표자에 합침으로써 a집합을 b집합에 합침.
        return true;
    }
}
