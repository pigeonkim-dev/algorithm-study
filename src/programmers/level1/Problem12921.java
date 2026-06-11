package programmers.level1;

import java.util.HashSet;

public class Problem12921 {
    public void run() {
        int number = 10;
        int result = solution(number);
        System.out.println(result);
    }

    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i <= n; i++) {

            if (isPrime(i)) {
                answer++;
            }
        }

        return answer;
    }
    public boolean isPrime(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) return false;  // 나누어 떨어지면 소수 아님
        }
        return true;  // 끝까지 통과하면 소수
    }
}
