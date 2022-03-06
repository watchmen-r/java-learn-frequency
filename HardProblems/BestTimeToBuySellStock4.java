class BestTimeToBuySellStock4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][k + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int transactionsRemaining = 1; transactionsRemaining <= k; transactionsRemaining++) {
                for (int holding = 0; holding < 2; holding++) {
                    int doNothing = dp[i + 1][transactionsRemaining][holding];
                    int doSomething;
                    if(holding == 1) {
                        // 持っている場合は売る
                        doSomething = prices[i] + dp[i + 1][transactionsRemaining - 1][0];
                    } else {
                        // 持っていない場合は買う
                        doSomething = -prices[i] + dp[i + 1][transactionsRemaining][1];
                    }
                    dp[i][transactionsRemaining][holding] = Math.max(doNothing, doSomething);
                }
            }
        }
        return dp[0][k][0];
    }
}