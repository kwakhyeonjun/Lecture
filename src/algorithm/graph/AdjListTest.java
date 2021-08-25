package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjListTest {

    static class Node{
        int vertex; // 인접 정점 인덱스
        Node link;
        public Node(int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }
        @Override
        public String toString(){
            return "Noew [vertex=" + vertex + ", link =" + link + "]";
        }
    }

    static int N;
    static Node[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjList = new Node[N];
        int C = Integer.parseInt(br.readLine()); // 간선 개수
        for(int i = 0; i <C; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);
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

            // 현재 노드의 인접 리스트를 따라가면서 반복문을 진행함.
            for(Node temp = adjList[current]; temp != null; temp = temp.link){
                if(!visited[temp.vertex]){
                    queue.offer(temp.vertex);
                    visited[temp.vertex] = true;
                }
            }
        }
    }

    private static void dfs(int current, boolean[] visited){
        visited[current] = true;
        System.out.println((char)(current + 65));
        for(Node temp = adjList[current]; temp != null; temp = temp.link){
            if(!visited[temp.vertex]){
                dfs(temp.vertex, visited);
            }
        }
    }
}
