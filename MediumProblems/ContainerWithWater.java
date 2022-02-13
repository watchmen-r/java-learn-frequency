class ContainerWithWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int area = 0;
        while (left < right) {
            area = Math.max(area, (right - left) * Math.min(height[right], height[left]));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}