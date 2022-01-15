import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int answer = -500000;

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sumNum = nums[i] + nums[left] + nums[right];
                
                int nowDiff = Math.abs(target - answer);
                int newDiff = Math.abs(target - sumNum);

                if(newDiff < nowDiff) {
                    answer = sumNum;
                }

                if(sumNum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return answer;
    }
}