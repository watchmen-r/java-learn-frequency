class ContainerWithWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int answer = 0;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            answer = Math.max(answer, minHeight * minHeight * (right - left));
            if(left <= right) {
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }
}