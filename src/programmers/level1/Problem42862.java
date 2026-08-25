package programmers.level1;

import java.util.*;

public class Problem42862 {
    public void run() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println(solution(n, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        // TODO: 여분도 있고 도난도 당한 학생은 자기 자신이 입어야 하므로
        //       lost와 reserve에서 중복된 번호를 먼저 제거하기

        boolean[] lostArr = new boolean[n + 1];
        boolean[] reserveArr = new boolean[n + 1];

// 올바른 방법
        for (int l : lost) lostArr[l] = true;
        for (int r : reserve) reserveArr[r] = true;

// 중복 제거
        for (int i = 1; i <= n; i++) {
            if (lostArr[i] && reserveArr[i]) {
                lostArr[i] = false;
                reserveArr[i] = false;
            }
        }

        // TODO: lost에 남은 학생들에게 앞(i-1) 또는 뒤(i+1) 번호 학생이
        //       reserve에 있으면 빌려주기 (빌려준 학생은 reserve에서 제거)

        for (int i = 1; i <= n; i++) {
            if (lostArr[i]) {
                if (i - 1 >= 1 && reserveArr[i - 1]) {
                    reserveArr[i - 1] = false;
                    lostArr[i] = false;
                } else if (i + 1 <= n && reserveArr[i + 1]) {
                    reserveArr[i + 1] = false;
                    lostArr[i] = false;
                }
            }
        }


        // TODO: 참여 가능 인원 = 전체(n) - 최종적으로 lost에 남은 학생 수

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (lostArr[i]) count++;
        }

        return n - count;
    }
}
