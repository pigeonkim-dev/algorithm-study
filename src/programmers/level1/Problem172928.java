package programmers.level1;

import java.util.Arrays;

public class Problem172928 {
    public void run() {
        System.out.println(Arrays.toString(solution(
                new String[]{"SOO", "OOO", "OOO"},
                new String[]{"E 2", "S 2", "W 1"}))); // [2, 1]
        System.out.println(Arrays.toString(solution(
                new String[]{"SOO", "OXX", "OOO"},
                new String[]{"E 2", "S 2", "W 1"}))); // [0, 1]
        System.out.println(Arrays.toString(solution(
                new String[]{"OSO", "OOO", "OXO", "OOO"},
                new String[]{"E 2", "S 3", "W 1"}))); // [0, 0]
    }

    public int[] solution(String[] park, String[] routes) {

        int pointX = 0, pointY = 0;

        for (int i = 0; i < park.length; i++) {
            String[] row = park[i].split("");
            for (int k = 0; k < row.length; k++) {
                if (row[k].equalsIgnoreCase("S")) {
                    pointX = i;
                    pointY = k;
                    break;
                }
            }

            if (pointX > 0 && pointY > 0) {
                break;
            }
        }

        int tempX = 0;
        int tempY = 0;

        for (int i = 0; i < routes.length; i++) {
            tempX = pointX;
            tempY = pointY;

            String[] route = routes[i].split(" ");
            boolean failContidion = false;
            for (int k = 0; k < Integer.parseInt(route[1]); k++) {

                if (route[0].equalsIgnoreCase("N")) {
                    tempX = tempX - 1;
                }

                if (route[0].equalsIgnoreCase("S")) {
                    tempX = tempX + 1;
                }

                if (route[0].equalsIgnoreCase("W")) {
                    tempY = tempY - 1;
                }

                if (route[0].equalsIgnoreCase("E")) {
                    tempY = tempY + 1;
                }

                if (tempX < 0 || tempX >= park.length || tempY < 0 || tempY >= park[0].length()) {
                    failContidion = true;
                    break;
                }

                if (park[tempX].charAt(tempY) == 'X') {
                    failContidion = true;
                    break;
                }
            }

            if (!failContidion) {
                pointX = tempX;
                pointY = tempY;
            }
        }

        return new int[]{pointX, pointY};
    }
}
