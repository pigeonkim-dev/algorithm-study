package programmers.level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem1844 {
    public void run() {
        int[][] maps1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int[][] maps2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };
        System.out.println(solution(maps1)); // 15
        System.out.println(solution(maps2)); // -1
    }

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 상하좌우 이동 방향
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // TODO: BFS
        //       Queue에 시작점(0,0)을 넣고 출발
        //       꺼낸 칸의 상하좌우를 확인해 이동 가능하면 Queue에 추가
        //       이미 방문한 칸은 다시 넣지 않는다 (maps 값을 0으로 바꾸거나 별도 visited 배열 사용)
        //       목적지(n-1, m-1)에 도달하면 거리를 반환
        //       Queue가 빌 때까지 도달 못 하면 -1 반환

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1}); // {행, 열, 거리}
        maps[0][0] = 0;

        int distance = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            if (temp[0] == n - 1 && temp[1] == m - 1) {
                return temp[2];
            }

            distance = temp[2];

            for (int i = 0; i < dr.length; i++) {

                if (temp[0] + dr[i] < 0 || temp[1] + dc[i] < 0) {
                    continue;
                }

                if (temp[0] + dr[i] > maps[0].length - 1 || temp[1] + dc[i] > maps[1].length - 1) {
                    continue;
                }

                if (maps[temp[0] + dr[i]][temp[1] + dc[i]] == 1) {
                    queue.add(new int[]{temp[0] + dr[i], temp[1] + dc[i], distance + 1});
                    maps[temp[0] + dr[i]][temp[1] + dc[i]] = 0;
                }
            }
        }

        return -1;
    }
}
