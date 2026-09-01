package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem118669 {
    public void run() {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "kai"};
        System.out.println(Arrays.toString(solution(players, callings)));
        // 기대값: [kai, mumu, soe, mine, poe]
    }

    public String[] solution(String[] players, String[] callings) {
        // TODO: 이름 → 현재 순위(인덱스)를 빠르게 찾기 위한 Map 준비
        //       players 배열을 순회하며 (이름, 인덱스) 쌍으로 채운다

        Map<String, Integer> rankMap = IntStream.range(0, players.length)
                .boxed()
                .collect(Collectors.toMap(
                        i -> players[i],
                        i -> i
                ));

        // TODO: callings를 순서대로 처리
        //       불린 선수의 현재 순위를 rankMap에서 꺼내고
        //       바로 앞 순위 선수와 players 배열 + rankMap 양쪽을 동시에 교환한다
        for (String name : callings) {
            int currentIndex =  rankMap.get(name);
            int previousIndex = currentIndex -1;

            String previousName = players[previousIndex];

            players[previousIndex] = name;
            players[currentIndex] = previousName;

            rankMap.replace(name, previousIndex);
            rankMap.replace(previousName, currentIndex);

        }

        return players;
    }
}
