package programmers.level1;

public class Problem136798 {
    public void run() {
        System.out.println(solution(5, 3, 2));   // 기대값: 10
        System.out.println(solution(10, 3, 2));  // 기대값: 21
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {

            int count = 0;

            for (int j = 1; j <= i; j++) {

                if (i % j == 0) {
                    count++;
                }

            }

            if (count > limit) {
                answer += power;
            }else {
                answer += count;
            }

        }

        return answer;
    }
}
