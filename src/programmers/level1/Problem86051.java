package programmers.level1;

import java.util.Arrays;

public class Problem86051 {
    public void run() {
        System.out.println(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0})); // 14 (5 + 9)
    }

    public int solution(int[] numbers) {
        // TODO
        int result = 0;
        for (int i = 0; i < 10; i++){
            boolean ismatch = false;
            for (int j = 0; j < numbers.length; j++){
                if (numbers[j] == i){
                    ismatch = true;
                    break;
                }
            }

            if (!ismatch){
                result +=i;
            }

        }

        return result;
    }
}
