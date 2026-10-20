package programmers.level1;

public class Problem132267 {
    public void run() {
        System.out.println(solution(2, 1, 20)); // 19
        System.out.println(solution(3, 1, 20)); // 9
    }

    public int solution(int a, int b, int n) {

        int answer = 0;

        while (n >= a) {

            int newcolacount = (n / a) * b;

            answer += newcolacount;
            //콜라 마셔서 새콜라가 빈병 갯수가됨
            n = n % a + newcolacount;
        }

        return answer;
    }
}
