class Knapsack {
    public int knapsack(int N, int W, int[] value, int[] weight) {

        // DP初期化 全部0で良い
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 0; i < N; i++) {
            for (int w = 0; w <= W; w++) {
                if (w >= weight[i]) {
                    dp[i + 1][w] = Math.max(dp[i][w-weight[i]] + value[i], dp[i][w]);
                } else {
                    dp[i + 1][w] = dp[i][w];
                }
            }
        }
        return dp[N][W];
    }
}