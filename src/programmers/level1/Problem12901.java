package programmers.level1;

public class Problem12901 {
    public void run() {
        System.out.println(solution(5, 24));  // TUE
        System.out.println(solution(1, 1));   // FRI
        System.out.println(solution(12, 31)); // SAT
    }

    public String solution(int a, int b) {
        String answer = "";
        int[] month = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] yo = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int days = 0;

        for (int i = 0; i < a - 1; i++) {
            days += month[i];
        }

        days += b;

        days -= 1;

        int index = days % 7;

        return yo[index];
    }
}
