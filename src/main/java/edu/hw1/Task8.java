package edu.hw1;

final class Task8 {
    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        final int BOARD_SIZE = 8;
        final int MOVE = -2;

        int[][] moves = new int[][] {{-1, MOVE}, {MOVE, -1}, {1, MOVE}, {2, -1}, {-1, 2}, {MOVE, 1}, {1, 2}, {2, 1}};
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < BOARD_SIZE; k++) {
                        int i1 = i + moves[k][0];
                        int j1 = j + moves[k][1];
                        if (i1 >= 0 && i1 < BOARD_SIZE && j1 >= 0 && j1 < BOARD_SIZE) {
                            if (board[i1][j1] == 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
