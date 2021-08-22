package algorithm.bruteForce;

import java.util.Arrays;

public class NextPermutationTest {
    public static void main(String[] args) {
        int[] input = {7, 1, 4};

        Arrays.sort(input); // 1, 4, 7

        do{ // 최초에 정렬된 순열을 사용해야 함.
            //순열 사용
            System.out.println(Arrays.toString(input));
        }while(nextPermutation(input)); // 다음 순열 생성
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
        int j = N;
        while (numbers[i] >= numbers[j]) --j; // 꼭댁기의 크기보다 바로 전에 작은 값을 가진 위치 j를 찾는다.
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
