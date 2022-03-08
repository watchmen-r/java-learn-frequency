class BinaryGap {
    public int solution(int N) {
        String n2 = Integer.toBinaryString(N);

        int max = 0;
        boolean oneFlag = false;
        int zeroCount = 0;
        for (int i = 0; i < n2.length(); i++) {
            char curChar = n2.charAt(i);

            if(curChar == '1') {
                oneFlag = true;
                max = Math.max(max, zeroCount);
                zeroCount = 0;
                continue;
            }

            if(oneFlag) {
                zeroCount++;
            }

        }
        return max;
    }
}
