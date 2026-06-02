package programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem68644 {
    public void run() {
        int[] numbers = {2,1,3,4,1};
        int[] result = solution(numbers);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> set =  new HashSet<>();

        for (int i = 0; i < numbers.length -1; i++) {
            for (int j = i+1; j < numbers.length -1; j++) {
                set.add((numbers[i] + numbers[j]));
            }
        }

        answer= set
                .stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;

    }
}
