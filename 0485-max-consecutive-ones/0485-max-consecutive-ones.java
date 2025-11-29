class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = Integer.MIN_VALUE;
        int localCount = 0;
        for(int i=0; i<nums.length; i++) {
            maxCount = Math.max(maxCount, localCount);
            if(nums[i] == 1) {
                localCount++;
            } else {
                localCount = 0;
            }
        }
        maxCount = Math.max(maxCount, localCount);
        return maxCount;
    }
}