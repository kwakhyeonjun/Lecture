package algorithm.tree;

public class CompleteBinaryTree {
    private char[] nodes;
    private final int SIZE;
    private int lastIndex = 0;

    public CompleteBinaryTree(int size){
        this.SIZE = size;
        nodes = new char[size+1];
    }

    public void add(char c){
        nodes[++lastIndex] = c;
    }

    public void dfsByPreOrder(){
        System.out.print("Preorder : ");
        dfsByPreOrder(1);
        System.out.println();
    }

    /**
     * 1. 현재 노드 처리
     * 2. 왼쪽 자식 노드 방문
     * 3. 오른쪽 자식 노드 방문
     * @param current 현재 탐색할 노드의 인덱스
     */
    private void dfsByPreOrder(int current){
        // 1. 현재 노드 처리
        System.out.print(nodes[current] + " ");
        // 2. 왼쪽 자식 노드 방문
        if(current*2 <= lastIndex) dfsByPreOrder(current * 2);
        // 3. 오른쪽 자식 노드 방문
        if(current*2+1 <= lastIndex) dfsByPreOrder(current * 2 + 1);
    }

    public void dfsByInOrder(){
        System.out.print("Inorder : ");
        dfsByInOrder(1);
        System.out.println();
    }

    public void dfsByInOrder(int current){
        // 1. 왼쪽 자식 노드 방문
        if(current*2 <= lastIndex) dfsByInOrder(current * 2);
        // 2. 현재 노드 처리
        System.out.print(nodes[current] + " ");
        // 3. 오른쪽 자식 노드 방문
        if(current*2+1 <= lastIndex) dfsByInOrder(current * 2 + 1);
    }

    public void dfsByPostOrder(){
        System.out.print("Postorder : ");
        dfsByPostOrder(1);
        System.out.println();
    }

    public void dfsByPostOrder(int current){
        // 1. 왼쪽 자식 노드 방문
        if(current*2 <= lastIndex) dfsByPostOrder(current * 2);
        // 2. 오른쪽 자식 노드 방문
        if(current*2+1 <= lastIndex) dfsByPostOrder(current * 2 + 1);
        // 3. 현재 노드 처리
        System.out.print(nodes[current] + " ");

    }

}
