package programmers.level1;

import java.util.HashMap;
import java.util.HashSet;

public class Problem12928 {
    public void run() {
        int[] participant={1,2,3,4,6,7,8,0};
        int result = solution(participant);
        System.out.println(result);
    }

    public int solution(int[] numbers) {
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int number : numbers) {
            set.add(number);
        }

        for(int i = 0; i <= 9; i++) {
            if(!set.contains(i)) {
                answer = answer + i;
            }
        }

        return answer;
    }
}
