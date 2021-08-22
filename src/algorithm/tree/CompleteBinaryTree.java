package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

    private char[] nodes; // 저장하게될 노드들
    private final int SIZE; // 배열의 최대 크기
    private int lastIndex; // 바지막으로 추가된 노드의 인덱스

    public CompleteBinaryTree(int size) {
        this.SIZE = size;
        nodes = new char[size + 1]; // 1번부터 저장
    }

    public void add(char c){
        if(lastIndex == SIZE) return; // 가득 찬 상황 - 크기를 더 늘리지 않을 것이므로
        nodes[++lastIndex] = c; // 최초의 lastIndex가 0이므로 전위연산자 사용
    }

    public void bfs(){
        // 탐색을 기다리는 노드들이 저장됨
        // 배열로 관리하므로 탐색할 노드를 관리하는 인덱스를 저장
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // Root node Index 저장

        int current = 0; // 탐색할 노드의 인덱스 임시로 저장
        while(!queue.isEmpty()){ // queue가 빌때까지 반복
            current = queue.poll();
            System.out.println(nodes[current]); // 노드 접근
            // 왼쪽 자식 인덱스 번호가 유효한 인덱스 번호이므로 자식 노드가 있음을 확인
            if(current*2 <= lastIndex) {
                queue.offer(current*2);
            }
            // 오른쪽 자식노드 유효성 검사
            if(current*2+1 <= lastIndex){
                queue.offer(current*2 + 1);
            }
        }

    }
}
