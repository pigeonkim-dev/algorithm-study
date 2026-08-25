package programmers.level1;

import java.util.Arrays;

public class Problem77484 {
    public void run() {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        // 맞힌 개수 → 순위 변환표 (인덱스 = 맞힌 개수)
        int[] rankTable = {6, 6, 5, 4, 3, 2, 1};

        // TODO: 0의 개수 세기
        int zeroCount = 0;

        // TODO: win_nums와 실제로 일치하는 개수 세기
        int matchCount = 0;

        for (int i = 0; i < lottos.length; i++) {

            if (lottos[i] == 0) {
                zeroCount++;
            }

            for (int j = 0; j < win_nums.length; j++) {
                if (win_nums[i] == lottos[j]) {
                    matchCount++;
                }
            }
        }

        // TODO: 최고 순위 = zeroCount + matchCount 로 rankTable 조회
        // TODO: 최저 순위 = matchCount 만으로 rankTable 조회

        int best = rankTable[zeroCount + matchCount];
        int worst = rankTable[matchCount];
        return new int[]{best, worst};

    }
}
