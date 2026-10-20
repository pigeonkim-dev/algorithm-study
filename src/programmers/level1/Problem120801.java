package programmers.level1;

public class Problem120801 {
    public void run() {
        System.out.println(solution("100", "2345"));   // -1
        System.out.println(solution("100", "203045")); // 0
        System.out.println(solution("12", "1221"));    // 21

    }

    public String solution(String X, String Y) {

        char[] arrX = X.toCharArray();
        char[] arrY = Y.toCharArray();

        int[] countX = new int[10];
        int[] countY = new int[10];
        int[] countMin = new int[10];
        for (int i = 0; i < 10; i++) {
            for (char x : arrX) {
                if (i == Integer.parseInt(String.valueOf(x))) {
                    countX[i]++;
                }
            }

            for (char c : arrY) {
                if (i == Integer.parseInt(String.valueOf(c))) {
                    countY[i]++;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            countMin[i] = Math.min(countX[i], countY[i]);
        }
        StringBuilder result = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            if (countMin[i] != 0) {
                result.append(String.valueOf(i).repeat(Math.max(0, countMin[i])));
            }
        }

        if (result.isEmpty()) {
            return "-1";
        }

        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();

    }
}
