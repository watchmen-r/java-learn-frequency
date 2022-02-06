import java.util.Stack;

class FloodFill {
    int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];

        int originColor = image[sr][sc];

        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{sr, sc});

        while(!stack.isEmpty()) {
            int[] nowCell = stack.pop();

            image[nowCell[0]][nowCell[1]] = newColor;
            visited[nowCell[0]][nowCell[1]] = true;

            for(int[] dir: direction) {
                if(nowCell[0] + dir[0] >= 0 && nowCell[0] + dir[0] < image.length &&
                nowCell[1] + dir[1] >= 0 && nowCell[1] + dir[1] < image[0].length && 
                image[nowCell[0] + dir[0]][nowCell[1] + dir[1]] == originColor && 
                !visited[nowCell[0] + dir[0]][nowCell[1] + dir[1]]) {
                    stack.add(new int[]{nowCell[0] + dir[0], nowCell[1] + dir[1]});
                }
            }
        }
        return image;
    }
}