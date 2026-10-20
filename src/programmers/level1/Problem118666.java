package programmers.level1;

public class Problem118666 {
    public void run() {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5})); // TCMA
        System.out.println(solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));                   // RCJA
    }

    public String solution(String[] survey, int[] choices) {

        StringBuilder sb = new StringBuilder();

        int[] scoreRCJA = new int[4];
        int[] scoreTFMN = new int[4];

        for (int i = 0; i < choices.length; i++) {
            char c;
            if (choices[i] > 4) {
                c = survey[i].charAt(1);
            } else {
                c = survey[i].charAt(0);
            }

            if (c == 'R') {
                scoreRCJA[0] += Math.abs(choices[i] - 4);
            }
            if (c == 'C') {
                scoreRCJA[1] += Math.abs(choices[i] - 4);
            }
            if (c == 'J') {
                scoreRCJA[2] += Math.abs(choices[i] - 4);
            }
            if (c == 'A') {
                scoreRCJA[3] += Math.abs(choices[i] - 4);
            }

            if (c == 'T') {
                scoreTFMN[0] += Math.abs(choices[i] - 4);
            }
            if (c == 'F') {
                scoreTFMN[1] += Math.abs(choices[i] - 4);
            }
            if (c == 'M') {
                scoreTFMN[2] += Math.abs(choices[i] - 4);
            }
            if (c == 'N') {
                scoreTFMN[3] += Math.abs(choices[i] - 4);
            }
        }

        if (scoreRCJA[0] >= scoreTFMN[0]) {
            sb.append('R');
        } else {
            sb.append('T');
        }

        if (scoreRCJA[1] >= scoreTFMN[1]) {
            sb.append('C');
        } else {
            sb.append('F');
        }

        if (scoreRCJA[2] >= scoreTFMN[2]) {
            sb.append('J');
        } else {
            sb.append('M');
        }

        if (scoreRCJA[3] >= scoreTFMN[3]) {
            sb.append('A');
        } else {
            sb.append('N');
        }


        return sb.toString();
    }
}
