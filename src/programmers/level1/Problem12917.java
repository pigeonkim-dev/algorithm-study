package programmers.level1;

import java.util.Arrays;

public class Problem12917 {
    public void run() {
        System.out.println(solution("Zbcdefg")); // gfedcbZ
        System.out.println(solution("ZzAa"));    // zaZA
        System.out.println(solution("a"));       // a
    }

    public String solution(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);

        StringBuilder sb = new StringBuilder();
        for(int i = charArray.length-1; i >= 0; i-- ){
            sb.append(charArray[i]);
        }

        return sb.toString();
    }
}
