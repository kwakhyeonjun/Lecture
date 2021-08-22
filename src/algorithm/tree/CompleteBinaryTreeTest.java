package algorithm.tree;

public class CompleteBinaryTreeTest {
    public static void main(String[] args) {
        int size = 9;
        CompleteBinaryTree tree = new CompleteBinaryTree(size);

        for(int i = 0; i < size; i++){ // `A~I
            // A부터 순서대로 저장함
            tree.add((char)(65 + i));
        }
        tree.bfs();
    }
}
