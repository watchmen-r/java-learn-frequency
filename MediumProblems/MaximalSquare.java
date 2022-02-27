class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        int maxAnswer = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j]), dp[i][j + 1]) + 1;
                    maxAnswer = Math.max(maxAnswer, dp[i + 1][j + 1]);
                }
            }
        }
        return maxAnswer * maxAnswer;
    }
}