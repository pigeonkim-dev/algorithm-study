package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class Problem42578 {
    public void run() {
        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes1)); // 5
        System.out.println(solution(clothes2)); // 3
    }

    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {

            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }

        return map.
                values().
                stream().
                reduce(1, (x, y)
                        -> x * (y + 1)) - 1;
    }
}
