package programmers.level1;

public class Problem12931 {
    public void run() {
        System.out.println(solution(123));       // 6
        System.out.println(solution(987));       // 24
        System.out.println(solution(100000000)); // 1
    }

    public int solution(int n) {


        int answer = 0;
        int digit = 0;
        while (n > 0) {
            digit = n%10;
            n = n/10;

            answer+= digit;
        }

        return answer;
    }
}
