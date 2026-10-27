package programmers.level1;

import java.util.Arrays;

public class Problem12935 {
    public void run() {
        System.out.println(Arrays.toString(solution(new int[]{4, 3, 2, 1}))); // [4, 3, 2]
        System.out.println(Arrays.toString(solution(new int[]{10})));         // [-1]
        System.out.println(Arrays.toString(solution(new int[]{3, 1, 5, 2}))); // [3, 5, 2]
    }

    public int[] solution(int[] arr) {

        if (arr.length == 1)
            return new int[]{-1};

        int tempSmall = Integer.MAX_VALUE;
        int tempIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            tempSmall = Math.min(tempSmall, arr[i]);
            if(tempSmall == arr[i]){
                tempIndex = i;
            }
        }

        int[] answer = new int[arr.length - 1];

        int answerIndex = 0;
        for (int j = 0; j < arr.length; j++) {
            if (tempIndex != j) {
                answer[answerIndex] = arr[j];
                answerIndex++;
            }
        }

        return answer;
    }
}
