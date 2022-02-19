class TrappingRain {

    public static void main(String[] args) {

    }

    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int maxLeft = 0;
        int maxRight = 0;

        int totalWater = 0;

        while(left < right) {
            // pointer２つが鉢合わせた時、小さい方基準で水が貯まるから
            if(height[left] < height[right]) {
                if(height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalWater += maxLeft - height[left];
                }
                left++;
            } else {
                if(height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    totalWater += maxRight - height[right];
                }
                right--;
            } 
        }
        return totalWater;
    }
}