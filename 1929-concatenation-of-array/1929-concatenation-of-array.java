class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        if(n == 0) return new int[0];
        int[] ans = new int[2*n];
        for(int i=0, j=n; i<n; i++, j++) {
            ans[i] = nums[i];
            ans[j] = nums[i];
        }
        return ans;
    }
}