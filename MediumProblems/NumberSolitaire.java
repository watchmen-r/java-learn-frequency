class App {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, -2, 0, 9, -1, -2}));
    }

    public static int solution(int[] A) {
        int[] dp = new int[A.length + 1];

        dp[0] = A[0];

        for(int i = 1; i < A.length; i++) {
            int max = Integer.MIN_VALUE;

            for(int j = 6; j > 0; j--) {
                if((i - j) < 0) {
                    continue;
                }
                max = Math.max(max, A[i] + dp[i - j]);

            }
            dp[i] = max;
        }
        return dp[A.length-1];
    }
}