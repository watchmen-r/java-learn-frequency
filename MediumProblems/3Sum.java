class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if(i == 0 || nums[i-1] != nums[i]) {
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    static void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while(lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            // sortしているのでマイナスであればloを＋に移動させる
            if(sum < 0) {
                lo++;
            } else if(sum > 0) {
                hi--;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                lo++; hi--;
                // 次のloやhiが同じだった場合は、同じ答えになってしまうため飛ばす
                while(lo < hi && nums[lo] == nums[lo - 1]) {
                    lo++;
                }
            }
        }
    }
}