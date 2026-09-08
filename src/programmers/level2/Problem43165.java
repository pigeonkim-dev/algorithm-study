package programmers.level2;

public class Problem43165 {
    public void run() {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));    // 2
    }

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    // TODO: 재귀 함수
    //       현재 인덱스와 현재까지의 합을 받아,
    //       배열 끝에 도달했을 때 합이 target과 같으면 1, 아니면 0을 반환한다
    //       각 단계에서 +와 - 두 경우를 모두 재귀 호출하여 합산한다
    private int dfs(int[] numbers, int target, int index, int sum) {

        if (index == numbers.length) {
            if (target == sum) {
                return 1;
            } else {
                return 0;
            }
        }

        return dfs(numbers, target, index + 1, sum + numbers[index])
                + dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
