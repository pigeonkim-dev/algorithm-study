package programmers.level1;

import java.util.*;

public class Problem92334 {
    public void run() {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        // TODO: 신고자 → 신고한 피신고자 Set (중복 제거)
        //       Map<String, Set<String>> reportMap

        Map<String, Set<String>> reportMap = new HashMap<>();

        // TODO: report 배열 순회
        //       각 항목을 split(" ")으로 신고자/피신고자 분리
        //       reportMap에 추가 (Set이라 중복 자동 제거)

        for (int i = 0; i < report.length; i++) {
            String reporter = report[i].split(" ")[0];
            String reported = report[i].split(" ")[1];

            reportMap.computeIfAbsent(reporter, kv -> new HashSet<>()).add(reported);
        }

        // TODO: 피신고자별 신고 횟수 카운트
        //       Map<String, Integer> countMap
        //       reportMap을 순회하며 각 피신고자의 카운트 증가

        Map<String, Integer> map = new HashMap<>();

        for (Set<String> reportedList : reportMap.values()) {
            for (String reported : reportedList) {
                map.put(reported, map.getOrDefault(reported, 0) + 1);
            }
        }

        // TODO: 결과 배열 생성
        //       id_list 순서대로, 각 유저가 신고한 피신고자 중
        //       countMap 값이 k 이상인 경우 메일 수 +1

        int[] mailList = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {

            int mailCount = 0;

            Set<String> reportedList = reportMap.get(id_list[i]);

            if (reportedList == null) {
                mailList[i] = 0;
                continue;
            }

            for (String reported : reportedList) {

                int count = map.get(reported);

                if (count >= k) {
                    mailCount++;
                }
            }

            mailList[i] = mailCount;
        }

        return mailList;
    }
}
