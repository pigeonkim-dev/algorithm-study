package programmers.level1;

public class Problem147355 {
    public void run() {
        System.out.println(solution("3141592", "271")); // 2
        System.out.println(solution("500220839878", "7")); // 8
    }

    public int solution(String t, String p) {
        int lengthCount = p.length();
        char[] arrT = t.toCharArray();
        int pNum = Integer.parseInt(p);
        int answer = 0;

        for (int i = 0; i < arrT.length; i++) {
            if (lengthCount + i > arrT.length) {
                break;
            }
            int num = Integer.parseInt(t.substring(i, lengthCount + i));

            if (pNum >= num) {
                answer++;
            }
        }

        return answer;
    }
}
