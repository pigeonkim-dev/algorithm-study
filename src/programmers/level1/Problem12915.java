package programmers.level1;

import java.util.Arrays;

public class Problem12915 {
    public void run() {
        String[] strings = {"sun", "bed", "car"};
        int number = 1;
        String[] result = solution(strings, number);
        System.out.println(Arrays.toString(result));//{5,4,3,2,1}
    }

    public String[] solution(String[] strings, int n) {
        String[] answer = {};

       Arrays.sort(strings, (a, b) ->
        {
            if (a.charAt(n) > b.charAt(n)) {
                return 1;
            }else if (a.charAt(n) == b.charAt(n)) {
                return a.compareTo(b);
            }            else{
                return -1;
            }
        });

       answer = strings;

        return answer;
    }
}