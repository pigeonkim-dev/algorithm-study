package programmers.level1;

public class Problem81301 {
    public void run() {
        System.out.println(solution("one4seveneight"));  // 1478
        System.out.println(solution("23four5six7"));     // 234567
        System.out.println(solution("123"));             // 123
    }

    public int solution(String s) {
        // TODO: 영단어를 숫자 문자로 replace (zero→0, one→1, ... nine→9)

        s = s.replaceAll("zero", "0");
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");

        // TODO: Integer.parseInt()로 변환 후 return
        return Integer.parseInt(s);
    }
}
