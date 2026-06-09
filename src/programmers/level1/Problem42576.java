package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class Problem42576 {
    public void run() {
        String[] participant={"leo", "kiki", "eden"};
        String[] completion={"eden", "kiki"};
        String result = solution(participant, completion);
        System.out.println(result);
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

// 2단계: completion으로 횟수 차감
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

// 3단계: 횟수가 1 이상인 사람이 정답
        for (String p : participant) {
            // ???
            if (map.get(p) > 0) {
                return p;
            }
        }

        return answer;
    }
}

