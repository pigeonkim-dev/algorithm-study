package programmers.level2;

public class Problem42577 {
    public void run() {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"})); // false
        System.out.println(solution(new String[]{"123", "456", "789"}));             // true
        System.out.println(solution(new String[]{"1195524421", "119", "97674223"}));             // true
    }

    public boolean solution(String[] phone_book) {

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }

                if (phone_book[i].startsWith(phone_book[j])) {
                    return false;
                }
            }
        }

        return true;

    }
}
