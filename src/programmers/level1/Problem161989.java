package programmers.level1;

public class Problem161989 {
    public void run() {
        System.out.println(solution(8, 4, new int[]{2, 3, 6}));    // 2
        System.out.println(solution(5, 4, new int[]{1, 3}));       // 1
        System.out.println(solution(4, 1, new int[]{1, 2, 3, 4})); // 4
    }

    public int solution(int n, int m, int[] section) {

        int answer = 0;
        int roll = 0;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < section.length; j++) {
                if (i > section[j]) {
                    continue;
                }

                i = section[j] + m - 1;
                answer++;
            }
        }


        return answer;
    }
}
