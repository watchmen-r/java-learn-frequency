class WordSearch {
    int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    char[][] grid;

    boolean exist = true;
    boolean[][] visited;

    boolean dfs(int h, int v, int index, String word) {
        index++;
        if(index == word.length()) {
            return true;
        }

        visited[h][v] = true;

        for(int[] dir: direction) {
            if(h + dir[0] >= 0 && h + dir[0] < grid.length && 
            v + dir[1] >= 0 && v + dir[1] < grid[0].length && 
            grid[h + dir[0]][v + dir[1]] == word.charAt(index) && !visited[h + dir[0]][v + dir[1]]) {
                boolean result = dfs(h + dir[0], v + dir[1], index, word);

                if(result) {
                    return true;
                }

            }
        }
        visited[h][v] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        grid = board;

        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[board.length][board[0].length];
                    ans = dfs(i, j, 0, word);
                }
                if (ans) {
                    return ans;
                }
            }
        }
        return false;
    }
}