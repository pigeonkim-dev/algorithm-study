package programmers.level1;

public class Problem67256 {
    public void run() {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right")); // LRLLLRLLRRL
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));  // LRLLRRLLLRR
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));    // LLRLLRLLRL
    }

    public String solution(int[] numbers, String hand) {

        String[][] keypad = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}, {"*", "0", "#"}};
        int[][] currentPosition = new int[numbers.length][2];

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < keypad.length; j++) {
                for (int k = 0; k < keypad[j].length; k++) {
                    if (keypad[j][k].equals(String.valueOf(numbers[i]))) {
                        currentPosition[i][0] = j;
                        currentPosition[i][1] = k;
                        break;
                    }
                }
            }
        }

        int tempXright = 3;
        int tempYright = 2;

        int tempXleft = 3;
        int tempYleft =0;

        for (int i = 0; i < currentPosition.length; i++) {


            if (currentPosition[i][1] == 0) {
                builder.append("L");
                tempXleft = currentPosition[i][0];
                tempYleft = currentPosition[i][1];
            }

            if (currentPosition[i][1] == 2) {
                builder.append("R");
                tempXright = currentPosition[i][0];
                tempYright = currentPosition[i][1];
            }

            if (currentPosition[i][1] == 1) {

                int left = Math.abs(currentPosition[i][0] - tempXleft) + Math.abs(currentPosition[i][1] - tempYleft);
                int right = Math.abs((currentPosition[i][0] - tempXright) + (currentPosition[i][1] - tempYright));

                if (left < right) {
                    builder.append("L");
                    tempXleft = currentPosition[i][0];
                    tempYleft = currentPosition[i][1];
                }

                if (right < left) {
                    builder.append("R");
                    tempXright = currentPosition[i][0];
                    tempYright = currentPosition[i][1];
                }

                if (right == left && hand.equals("right")){
                    builder.append("R");
                    tempXright = currentPosition[i][0];
                    tempYright = currentPosition[i][1];
                }

                if (right == left && hand.equals("left")) {
                    builder.append("L");
                    tempXleft = currentPosition[i][0];
                    tempYleft = currentPosition[i][1];
                }
            }
        }

        return builder.toString();
    }
}
