package programmers.level2;

public class Problem42747 {
    public void run() {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5})); // 3
    }

    public int solution(int[] citations) {

        int answer = 0;
        int count = 0;

        for (int h = 1; h < citations.length; h++) {

            for (int i = 0; i < citations.length; i++) {
                if (h <= citations[i]) {
                    count++;
                }
            }

            if (count >= h) {
                answer = h;
            }

            count = 0;
        }

        return  answer;
    }
}
