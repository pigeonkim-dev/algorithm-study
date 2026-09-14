package programmers.level2;

import java.util.Arrays;

public class Problem42842 {
    public void run() {
        System.out.println(Arrays.toString(solution(10, 2))); // [4, 3]
        System.out.println(Arrays.toString(solution(8, 1)));  // [3, 3]
        System.out.println(Arrays.toString(solution(24, 24)));// [8, 6]
    }

    public int[] solution(int brown, int yellow) {
        // TODO: 세로를 3부터 sqrt(brown+yellow)까지 순회하며
        //       (1) 나누어 떨어지는지 확인
        //       (2) brown 조건 만족하는지 확인

        int total = brown + yellow;
        int h = 0;
        int w = 0;

        for (h = 3; h * h <= total; h++) {
            if (total % h == 0) {
                w = total / h;
            }

            if (2 * (w + h) - 4 == brown) {
                return new int[]{w, h};
            }
        }

        return new int[]{};
    }
}
