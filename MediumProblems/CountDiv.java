class CountDiv {
    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        int divB = B / K;
        int divA = (A-1) / K;

        return divB - divA;
    }
}