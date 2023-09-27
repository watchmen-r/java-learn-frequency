class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int begin = 0;
        int end = numbers.length - 1;

        while (begin < end) {
            int sum = numbers[begin] + numbers[end];
            if (sum == target) {
                break;
            }

            if (sum < target) {
                begin++;
            } else {
                end--;
            }
        }

        return new int[]{begin + 1, end + 1};
    }
}
