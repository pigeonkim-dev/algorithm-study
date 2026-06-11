package programmers.level1;

import java.util.Arrays;

public class Problem12932 {
    public void run() {
        int[] result = solution(12345);
        System.out.println(Arrays.toString(result));//{5,4,3,2,1}
    }

    public static int[] solution(long n) {

        String stringNumber = String.valueOf(n);
        char[] charArray = stringNumber.toCharArray();
        int[] answer = new int[charArray.length];
        int j = 0;

        for (int i = charArray.length -1 ; i >= 0; i--) {
                   answer[j]  = charArray[i] - '0';
                   j++;
        }

        return answer;

    }
}
