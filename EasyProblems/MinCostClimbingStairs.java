class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length + 1];

        // dp[0]とdp[1]はcost０で到達できるため、初期状態はすでに入っている
        for(int i = 2; i < dp.length; i++) {
            int oneStep = dp[i - 1] + cost[i - 1];
            int twoStep = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(oneStep, twoStep);
        }

        return dp[cost.length];
    }
}