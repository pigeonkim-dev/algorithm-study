package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class Problem42839 {
    public void run() {
        System.out.println(solution("17"));   // 3
        System.out.println(solution("011"));  // 2
    }



    public int solution(String numbers) {
        Set<Integer> candidates = new HashSet<>();
        boolean[] used = new boolean[numbers.length()];

        // TODO: DFS로 만들 수 있는 모든 수를 candidates에 수집한다
        dfs(numbers, used, "",  candidates);

        // TODO: candidates 중 소수인 것의 개수를 반환한다
        return Math.toIntExact(candidates.stream().filter(this::isPrime
        ).count());
    }

    private void dfs(String numbers, boolean[] used, String current,  Set<Integer> candidates) {

        if (!current.isEmpty()) {
            candidates.add(Integer.parseInt(current));
        }

        for (int j = 0; j < used.length; j++) {
            if (!used[j]) {
                used[j] = true;
                dfs(numbers, used, current+ numbers.split("")[j], candidates);
                used[j] = false;
            }
        }


    }

    private boolean isPrime(int n) {
        // TODO: n이 소수인지 판별한다
        //       2 미만은 소수가 아니다
        //       2부터 √n 까지 나누어 떨어지면 소수가 아니다

        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
