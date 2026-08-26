package programmers.level1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Problem64061 {
    public void run() {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int count = 0;
        Deque<Integer> queue = new ArrayDeque<Integer>();

        for (int i = 0; i < moves.length; i++) {
            for (int k = 0; k < board.length; k++) {

                if (board[k][moves[i] - 1] != 0) {

                    Integer num = queue.peekFirst();

                    if (num == null) {
                        queue.push(board[k][moves[i] - 1]);
                    } else {
                        if (num == board[k][moves[i] - 1]) {
                            queue.pop();
                            count += 2;
                        } else {
                            queue.push(board[k][moves[i] - 1]);
                        }
                    }

                    board[k][moves[i] - 1] = 0;
                    break;
                }
            }
        }

        return count;
    }
}
