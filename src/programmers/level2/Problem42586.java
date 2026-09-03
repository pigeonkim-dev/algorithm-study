package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem42586 {
    public void run() {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        // 기대값: [2, 1]
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
        // 기대값: [1, 3, 2]

        System.out.println(Arrays.toString(solution(new int[]{91, 98, 97}, new int[]{1, 1, 1})));
        // 기대값: [3]
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        // TODO: 각 기능의 남은 일수 계산
        //       (100 - progresses[i])를 speeds[i]로 나눌 때 올림 처리 필요
        //       Java에서 정수 올림: (a + b - 1) / b 또는 Math.ceil() 사용
        int[] days = new int[progresses.length];
        for (int j = 0; j < progresses.length; j++) {

            int dayCount = 0;

            for (int i = progresses[j]; i <= 100; i = i + speeds[j]) {
                dayCount++;
            }

            days[j] = dayCount;
        }


        // TODO: days 배열을 앞에서부터 순회하며 배포 묶음을 만든다
        //       기준은 맨 앞 기능의 days[i]
        //       뒤따르는 기능의 days가 기준 이하이면 같이 배포, 초과하면 새 묶음 시작

        int deployCount = 0;
        int DayNumber = 0;
        for (int i = 0; i < days.length; i++) {
            deployCount = 1;

            DayNumber = days[i];
            for (int j = i + 1; j < days.length; j++) {
                if (DayNumber >= days[j]) {
                    deployCount++;
                    i++;
                } else {
                    break;
                }
            }

            result.add(deployCount);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
