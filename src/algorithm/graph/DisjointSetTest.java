package algorithm.graph;


import java.util.Arrays;

public class DisjointSetTest {
    private static int N; // 원소개수
    private static int[] parents; // 부모원소를 관리(트리처럼 사용)

    public static void main(String[] args) {
        N = 5;
        parents = new int[N];

        // make set
        make(); // 0 to 4 단위집합 생성
        System.out.println(union(0, 1));            // union 내부에서 find가 불리는 것에 주의
        System.out.println(Arrays.toString(parents));     // [0, 0, 2, 3, 4]
        System.out.println(union(2, 1));            // 대표자가 되는 원소끼리 union하여, path compression이 일어나지 않음.
        System.out.println(Arrays.toString(parents));     // [2, 0, 2, 3, 4]
        System.out.println(union(3, 2));
        System.out.println(Arrays.toString(parents));     // [2, 0, 3, 3, 4]
        System.out.println(union(4, 3));
        System.out.println(Arrays.toString(parents));     // [2, 0, 3, 4, 4]

        System.out.println("================find===============");
        System.out.println(find(4));                   // find 과정에서 Path Compression 되는 것을 확인
        System.out.println(Arrays.toString(parents));     // [2, 0, 3, 4, 4]
        System.out.println(find(3));
        System.out.println(Arrays.toString(parents));     // [2, 0, 3, 4, 4]
        System.out.println(find(2));                   // 2번째 원소의 부모가 3이였지만, Path Compression을 통해 4로 변경됨.
        System.out.println(Arrays.toString(parents));     // [2, 0, 4, 4, 4]
        System.out.println(find(0));
        System.out.println(Arrays.toString(parents));     // [4, 0, 4, 4, 4]
        System.out.println(find(1));
        System.out.println(Arrays.toString(parents));     // [4, 4, 4, 4, 4]


    }

    // 최초에 모든 집합을 단위집합으로 생성
    private static void make(){
        // 모든 원소를 자신을 대표자로 만듦
        for(int i = 0; i < N; i++){
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
