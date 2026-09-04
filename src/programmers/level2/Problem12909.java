package programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem12909 {
    public void run() {
        System.out.println(solution("()()"));    // true
        System.out.println(solution("(())()"));  // true
        System.out.println(solution(")("));      // false
        System.out.println(solution("(()"));     // false
    }

    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        // TODO: s를 문자 단위로 순회
        //       '(' 이면 stack에 push
        //       ')' 이면 stack이 비어있으면 바로 false 반환, 아니면 pop
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }

            if (c == ')') {

                if (stack.isEmpty()){
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
