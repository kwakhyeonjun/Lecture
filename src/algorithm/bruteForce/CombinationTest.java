package algorithm.bruteForce;

import java.util.Arrays;

public class CombinationTest {
    private static int R = 2, N = 3;
    private static int[] numbers = new int[R];
    private static int[] input;

    public static void main(String[] args) {
        input = new int[]{3, 1, 5};
        combination(0, 0);
    }

    public static void combination(int count, int start){
        if(count == R){
            System.out.println(Arrays.toString(numbers));
            return;
        }else{
            for(int i = start; i < N; i++){
                numbers[count] = input[i];
                combination(count + 1, i + 1);
            }
        }
    }


}
