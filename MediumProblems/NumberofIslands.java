import java.util.Stack;

class NumberofIslands {

    int[][] traverse = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Stack<int[]> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                }

                // add start coordinate
                stack.add(new int[] { i, j });

                while (!stack.empty()) {
                    int[] now = stack.pop();
                    visited[now[0]][now[1]] = true;
                    for (int[] adja : traverse) {
                        if (now[0] + adja[0] >= 0 && now[1] + adja[1] >= 0 && now[0] + adja[0] < grid.length
                                && now[1] + adja[1] < grid[0].length && !visited[now[0] + adja[0]][now[1] + adja[1]]
                                && grid[now[0] + adja[0]][now[1] + adja[1]] == '1') {
                            stack.add(new int[] { now[0] + adja[0], now[1] + adja[1] });
                        }
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}