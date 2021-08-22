package algorithm.bruteForce;

import java.util.Arrays;

public class PermutationTest {
    static int R = 1,N = 3;
    static boolean[] isSelected;
    static int[] numbers;
    static int[] input;

    public static void main(String[] args) {

        input = new int[]{1, 4, 7};
        numbers = new int[R];
        isSelected = new boolean[N];

        permutation(0);
        permutationByFlag(0, 0);
    }

    /**
     * 재귀를 사용한 순열 찾기 - boolean[] 사용
     * @param count 뽑은 갯수
     */
    private static void permutation(int count){
        if(count == R){
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i = 0; i < N; i++){
            if(isSelected[i]) continue;

            numbers[count] = input[i];
            isSelected[i] = true;

            // 다음자리 순열 뽑음
            permutation(count + 1);
            isSelected[i] = false;
        }
    }

    /**
     * 재귀를 이용한 순열 - 비트마스킹 사용
     * @param count
     * @param flag
     */
    private static void permutationByFlag(int count, int flag){
        if(count == R){
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i = 0; i < N; i++){
            if((flag & 1<<i) != 0) continue;
            numbers[count] = input[i];
            permutationByFlag(count + 1, flag | 1<<i);
        }
    }
}
