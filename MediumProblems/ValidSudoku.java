import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set;
        
        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    System.out.println("111");
                    return false;
                }
                set.add(board[i][j]);
            }
        }

        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (set.contains(board[j][i])) {
                    System.out.println("222");
                    return false;
                }
                set.add(board[j][i]);
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                set = new HashSet<>();
                for (int row = 0; row < 3; row++) {
                    for (int column = 0; column < 3; column++) {
                        int index1 = i + row;
                        int index2 = j + column;
                        if (board[index1][index2] == '.') {
                            continue;
                        }
                        if (set.contains(board[index1][index2])) {
                            System.out.println("333");
                            return false;
                        }
                        set.add(board[index1][index2]);
                    }
                }
            }
        }
        return true;
    }
}
