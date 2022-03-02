import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        List<Integer> list = Arrays.asList(coins);
        Collections.sort(list, Collections.reverseOrder());
        int[] coinArray = list.toArray(new int[coinArray.length + 1]);

        // 無限に初期化
        for (int i = 1; i < coinArray.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < coinArray.length + 1; i++) {
            for (int j = coinArray[i - 1]; j < amount + 1;) {
                dp[i][j] = Math.min(dp[i - 1][j - coinArray[i - 1]] + 1, dp[i - 1][j]);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - coinArray[i - 1]] + 1);
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < coinArray.length + 1; i++) {
            answer = Math.min(answer, dp[i][amount]);
        }

        return answer;
    }
}