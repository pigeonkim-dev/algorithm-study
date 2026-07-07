package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class Problem42840 {
    public void run() {
        int[] answers = {1, 2, 3, 4, 5};
        //int[] answers = {1,3,2,4,2};
        int[] result = solution(answers);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    public int[] solution(int[] answers) {
        // 수포자 1, 2, 3의 찍기 패턴
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // TODO: 각 수포자가 몇 개 맞혔는지 세기
        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) {
                scores[0]++;
            }

            if (answers[i] == pattern2[i % pattern2.length]) {
                scores[1]++;
            }

            if (answers[i] == pattern3[i % pattern3.length]) {
                scores[2]++;
            }
        }

        // TODO: 최댓값과 같은 점수를 가진 수포자 번호를 리스트에 담기
        List<Integer> winners = new ArrayList<>();

// 최댓값 먼저 구하기
        int maxScore = 0;
        for (int score : scores) {
            if (score > maxScore) {
                maxScore = score;
            }
        }

// 최댓값과 같은 사람만 추가
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {   // ← > 0 이 아니라 == maxScore
                winners.add(i + 1);
            }
        }


        // TODO: 리스트를 int[] 배열로 변환하여 return
        return winners.stream().mapToInt(Integer::intValue).toArray();
    }
}
