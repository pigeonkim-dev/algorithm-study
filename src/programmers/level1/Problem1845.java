package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem1845 {
    public void run() {
        int[] input = {3,3,3,2,2,2};
        int result = solution(input);
        System.out.println(result);  // 기대: [1, 3, 0, 1]
    }

    public static int solution(int []arr) {

        int maxSelectCount = arr.length/2;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int monCategory = set.size();

        return Math.min(maxSelectCount, monCategory);

    }
}
