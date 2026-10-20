package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem150370 {
    public void run() {
        System.out.println(Arrays.toString(solution(
                "2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}))); // [1, 3]
        System.out.println(Arrays.toString(solution(
                "2020.01.01",
                new String[]{"Z 3", "D 5"},
                new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}))); // [1, 4, 5]
    }

    public int[] solution(String today, String[] terms, String[] privacies) {

        ArrayList<Integer> answer = new ArrayList<>();

        String[] todayArr = today.split("\\.");
        int numToday = Integer.parseInt(todayArr[0]) * 12 * 28 +
                Integer.parseInt(todayArr[1]) * 28 +
                Integer.parseInt(todayArr[2]);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] priv = privacies[i].split(" ");
            String[] startDateString = priv[0].split("\\.");

            int expire = map.get(priv[1]);

            int expireDate = Integer.parseInt(startDateString[0]) * 12 * 28 +
                    Integer.parseInt(startDateString[1]) * 28 +
                    Integer.parseInt(startDateString[2])
                    + expire * 28;

            if (numToday >= expireDate) {
                answer.add(i + 1);
            }
        }


        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
