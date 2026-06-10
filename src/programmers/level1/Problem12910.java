package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem12910 {
    public void run() {
        int[] input = {5,9,7,10};
        int divide = 5;
        int[] result = solution(input, divide);
        System.out.println(Arrays.toString(result));  // 기대: [1, 3, 0, 1]
    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }

        if (list.isEmpty()) return new int[]{-1};

        answer = list.stream().sorted().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}