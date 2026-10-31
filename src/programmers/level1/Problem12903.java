package programmers.level1;

public class Problem12903 {
    public void run() {
        System.out.println(solution("abcde")); // c
        System.out.println(solution("qwer"));  // we
        System.out.println(solution("a"));     // a
    }

    public String solution(String s) {
        String answer = "";

        boolean flag = s.length() % 2 == 0;

        int beginIndex = 0;
        int endIndex = 0;
        if (flag) {
            endIndex = (s.length() / 2) + 1;
            beginIndex = (s.length() / 2) - 1;
        } else {
            beginIndex = s.length() / 2;
            endIndex = beginIndex + 1;
        }

        return s.substring(beginIndex, endIndex);
    }
}
