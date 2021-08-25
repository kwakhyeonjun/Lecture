package algorithm.bruteForce;

import java.util.Arrays;

public class CombWithNextPermutationTest {
    public static void main(String[] args) {
        int[] input = {7, 1, 4, 2, 3};
        int N = input.length;
        int R = 3;

        int[] p = new int[N]; // next permutation을 통해 위치를 선택할 배열

        // 위쪽부터 R개만큼 1 채우기
        int count = 0;
        while(++count <= R) p[N-count] = 1;

//        Arrays.sort(input); // 1, 2, 3, 4, 7
        // 정렬하지 않음(뒤에서부터 선택하므로)

        do{ // 최초에 정렬된 조합을 사용해야 함.
            //조합 사용
            for(int i = 0; i < N; i++){
                if(p[i] == 1) // 선택된 경우
                    System.out.print(input[i] + " ");
            }
            System.out.println();
        }while(nextPermutation(p)); // 실제 숫자가 아니라 위치를 의미하는 p 배열을 선택
    }

    // 다음 큰 순열이 있으면 true, 없으면 false
    private static boolean nextPermutation(int[] numbers) {
        int N = numbers.length;

        // step 1. 꼭대기를 찾는다. 곡대기를 통해 교환 위치를 찾는다.
        int i = N - 1;
        while (i > 0 && numbers[i - 1] >= numbers[i]) --i; // 왼쪽이 현재보다 크다면 큰 것을 i로 지정

        if (i == 0) return false; // 맨 앞(절벽)까지 온 경우 더이상 큰 순열이 존재하지 않음.

        // step1에서 꼭대기를 찾은 경우
        // step 2. i-1 위치값과 교환할 큰 값 찾기
        int j = N - 1;
        while (numbers[i - 1] >= numbers[j]) --j; // 꼭댁기의 크기보다 바로 전에 작은 값을 가진 위치 j를 찾는다.
        // 이때 j는 반드시 존재, 경계를 벗어나는 경우 없음

        // step 3. i-1위치값과 j위치값 교환
        swap(numbers, i-1, j);

        // step 4. 꼭대기부터 맨 뒤까지 내림차순 형태의 순열을 오름차순으로 처리
        int k = N-1;
        while(i < k){ // 둘이 만나지 않는 경우 반복
            swap(numbers, i++, k--);
        }

        return true; // 모두 진행된 경우 다음 순열이 생성되어있음.
    }

    private static void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
