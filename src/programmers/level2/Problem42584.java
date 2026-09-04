package programmers.level2;

import java.util.Arrays;

public class Problem42584 {
    public void run() {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
        // 기대값: [4, 3, 1, 1, 0]
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {

            int current = prices[i];
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {

                count++;

                if (current > prices[j]) {
                    break;
                }
            }

            answer[i] = count;
        }

        return answer;
    }
}
